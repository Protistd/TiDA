QUnit.module("Workspaces");

QUnit.test("Dodanie nowej przestrzeni roboczej", assert => {
  const nav = document.getElementById("workspaceNav");
  const content = document.getElementById("content");

  const plusBtn = nav.querySelector('[data-sohno="new"]');
  plusBtn.click();

  const newBtn = nav.querySelector('[data-sohno="3"]');
  const newSection = content.querySelector('[data-sohno="3"]');

  assert.ok(newBtn, "Nowy przycisk został utworzony");
  assert.ok(newSection, "Nowa sekcja została utworzona");
  assert.equal(newBtn.textContent, "3", "Przycisk ma poprawny tekst");
  assert.equal(newSection.textContent, "Body #3", "Sekcja ma poprawną treść");
});

QUnit.module("CSS Switcher");

QUnit.test("Zmiana arkusza CSS", assert => {
  const linkNode = document.querySelector("link[rel=stylesheet]");
  const menuLinks = document.querySelectorAll("ul li a");

  menuLinks[1].click(); // red.css
  assert.ok(linkNode.href.includes("red.css"), "Arkusz CSS zmieniony na red.css");

  menuLinks[2].click(); // lime.css
  assert.ok(linkNode.href.includes("lime.css"), "Arkusz CSS zmieniony na lime.css");
});
