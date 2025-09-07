// static/js/experience.js
(async function () {
    const root = document.querySelector('#experience-list');
    if (!root) return;
  
    try {
      const res = await fetch('/api/experience', { headers: { 'Accept': 'application/json' } });
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const jobs = await res.json();
  
      root.innerHTML = jobs.map(j => `
        <div class="border rounded-2xl p-4">
          <div class="flex items-baseline justify-between">
            <div>
              <div class="font-medium">${j.role}, ${j.company}</div>
              <div class="text-sm text-neutral-600">${j.location}</div>
            </div>
            <div class="text-sm text-neutral-600">${j.dates}</div>
          </div>
          <ul class="mt-2 list-disc list-inside text-sm text-neutral-800">
            ${(j.bullets || []).map(b => `<li>${b}</li>`).join('')}
          </ul>
        </div>
      `).join('');
    } catch (e) {
      console.error('Failed to load experience', e);
      root.innerHTML = `<div class="text-sm text-neutral-500">Could not load experience.</div>`;
    }
  })();
  