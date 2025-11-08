console.log("cssSwitcher.js działa!");

document.addEventListener("DOMContentLoaded", () => {
  const linkNode = document.querySelector("link[rel=stylesheet]");
  const cssFiles = ["default.css", "red.css", "lime.css"];

  const menu = document.createElement("ul");
  menu.id = "cssSwitcherMenu";
  menu.style.margin = "20px";
  menu.style.padding = "10px";
  menu.style.border = "2px solid black";
  menu.style.background = "#eee";

  cssFiles.forEach(file => {
    const li = document.createElement("li");
    const a = document.createElement("a");
    a.href = "#";
    a.textContent = file.replace(".css", "");
    a.style.marginRight = "10px";
    a.addEventListener("click", (e) => {
      e.preventDefault();
      linkNode.href = "ui/" + file;
      console.log("Zmieniono CSS na:", file);
    });
    li.appendChild(a);
    menu.appendChild(li);
  });

document.body.appendChild(menu);

});
