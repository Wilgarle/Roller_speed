
(function(){
  const html = document.documentElement;
  const toggle = document.getElementById('themeToggle');
  const stored = localStorage.getItem('theme');
  if(stored){ html.setAttribute('data-theme', stored); }
  if(toggle){ toggle.addEventListener('click', ()=>{ const next = html.getAttribute('data-theme') === 'dark' ? 'light' : 'dark'; html.setAttribute('data-theme', next); localStorage.setItem('theme', next); }); }

  const burger = document.querySelector('.hamburger');
  const menu = document.querySelector('.menu');
  if(burger && menu){ burger.addEventListener('click', ()=>{ const open = menu.classList.toggle('open'); burger.setAttribute('aria-expanded', String(open)); }); }

  const path = location.pathname;
  document.querySelectorAll('.menu .link').forEach(a=>{ 
    const href = a.getAttribute('href'); 
    if((href === '/' && path === '/') || (href !== '/' && path.startsWith(href))){ 
      a.classList.add('active'); 
    } 
  });
})();
