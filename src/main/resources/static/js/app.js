// static/js/app.js
(async function () {
    // --- DOM hooks -------------------------------------------------------------
    const qEl     = document.querySelector('#q');        // <input id="q">
    const sortEl  = document.querySelector('#sort');     // <select id="sort">
    const gridEl  = document.querySelector('#grid');     // <div id="grid">
    const tagBar  = document.querySelector('#tagBar');   // <div id="tagBar">
    const clearEl = document.querySelector('#clear');    // <button id="clear">
  
    // Guard if the page doesn't have these elements
    if (!gridEl) {
      console.warn('app.js: #grid not found — is index.html loaded?');
      return;
    }
  
    // --- Data fetch ------------------------------------------------------------
    /** @type {Array<{id:string,title:string,subtitle?:string,year?:number,coverUrl?:string,tags?:string[],roles?:string[],link?:string}>} */
    let projects = [];
  
    try {
      const res = await fetch('/api/projects', { headers: { 'Accept': 'application/json' } });
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      projects = await res.json();
      console.log('Loaded projects:', projects);
    } catch (err) {
      console.error('Failed to fetch /api/projects. Using empty list.', err);
      projects = [];
    }
  
    // --- Tag set ---------------------------------------------------------------
    const allTags = Array.from(new Set(projects.flatMap(p => p.tags || []))).sort((a,b)=>a.localeCompare(b));
    const active  = new Set(); // selected tags
  
    // --- Rendering -------------------------------------------------------------
    function card(p) {
        const cover = p.coverUrl || 'https://picsum.photos/800/600?blur=2';
        const year  = Number.isFinite(p.year) ? p.year : '';
        const tags  = (p.tags||[]).slice(0,3).map(t=>`<span class="rounded-full border px-2 py-0.5">${t}</span>`).join('');
      
        return `
          <a href="/projects/${p.id}"
             class="group block rounded-2xl overflow-hidden border transition duration-300 hover:shadow-lg hover:-translate-y-1">
            <div class="relative aspect-[4/3] overflow-hidden bg-neutral-100">
              <img src="${cover}" alt="${p.title}" class="h-full w-full object-cover transition duration-500 group-hover:scale-105 group-hover:brightness-105" />
            </div>
            <div class="p-4">
              <div class="flex items-baseline justify-between">
                <h3 class="font-medium leading-tight">${p.title}</h3>
                <span class="text-xs text-neutral-500">${year}</span>
              </div>
              ${p.subtitle ? `<p class="mt-1 text-sm text-neutral-600 line-clamp-2">${p.subtitle}</p>` : ''}
              <div class="mt-3 flex flex-wrap gap-1 text-xs text-neutral-600">${tags}</div>
            </div>
          </a>
        `;
      }
          
      
  
    function renderTags() {
      if (!tagBar) return;
      tagBar.innerHTML = '';
      allTags.forEach(t => {
        const btn = document.createElement('button');
        btn.className = `rounded-full border px-3 py-1 mr-1 mb-1 ${active.has(t) ? 'bg-black text-white' : 'hover:bg-neutral-100'}`;
        btn.textContent = t;
        btn.onclick = () => {
          active.has(t) ? active.delete(t) : active.add(t);
          render();
        };
        tagBar.appendChild(btn);
      });
    }
  
    function render() {
      const query = (qEl?.value || '').toLowerCase().trim();
      const tokens = query.split(/\s+/).filter(Boolean);
  
      const byTags = p => active.size === 0 || Array.from(active).every(t => (p.tags || []).includes(t));
      const hay    = p => `${p.title} ${p.subtitle || ''} ${(p.tags || []).join(' ')} ${(p.roles || []).join(' ')}`.toLowerCase();
      const byQ    = p => tokens.every(t => hay(p).includes(t));
  
      let view = projects.filter(p => byTags(p) && byQ(p));
  
      if (sortEl) {
        view.sort((a, b) => (sortEl.value === 'asc' ? (a.year ?? 0) - (b.year ?? 0) : (b.year ?? 0) - (a.year ?? 0)));
      }
  
      gridEl.innerHTML = view.map(card).join('\n');
  
      // Empty state
      if (view.length === 0) {
        gridEl.innerHTML = `
          <div class="col-span-full text-center text-sm text-neutral-500 py-16">
            No projects match your filters.
          </div>`;
      }
    }
  
    // --- Events ----------------------------------------------------------------
    qEl?.addEventListener('input', render);
    sortEl?.addEventListener('change', render);
    clearEl?.addEventListener('click', () => {
      if (qEl) qEl.value = '';
      active.clear();
      render();
    });
  
    // --- Boot ------------------------------------------------------------------
    renderTags();
    render();
  })();
  