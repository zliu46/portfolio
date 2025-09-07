(async function () {
    const root = document.querySelector('#education-list');
    if (!root) return;
  
    try {
      const res = await fetch('/api/education', { headers: { 'Accept': 'application/json' } });
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const schools = await res.json();
  
      root.innerHTML = schools.map(s => `
        <div class="rounded-2xl border p-4">
          <div class="flex items-baseline justify-between">
            <div>
              <div class="font-medium">${s.degree}</div>
              <div class="text-sm text-neutral-600">${s.school} — ${s.location}</div>
            </div>
            <div class="text-sm text-neutral-600">${s.dates}</div>
          </div>
          ${s.details ? `<p class="mt-2 text-sm text-neutral-700">${s.details}</p>` : ''}
        </div>
      `).join('');
    } catch (e) {
      console.error('Failed to load education', e);
      root.innerHTML = `<div class="text-sm text-neutral-500">Could not load education.</div>`;
    }
  })();
  