document.addEventListener("DOMContentLoaded", () => {
  const nav = document.getElementById("workspaceNav");
  const content = document.getElementById("content");

  nav.querySelector('[data-sohno="new"]').addEventListener("click", (e) => {
    e.preventDefault();
    const existing = content.querySelectorAll('[data-sohcanv="workspace"]').length;
    const newNo = existing + 1;

    const newBtn = document.createElement("a");
    newBtn.href = "#w" + newNo;
    newBtn.textContent = newNo;
    newBtn.setAttribute("data-sohbtn", "workspace");
    newBtn.setAttribute("data-sohgroup", "workspace");
    newBtn.setAttribute("data-sohno", newNo);

    nav.insertBefore(newBtn, nav.querySelector('[data-sohno="new"]'));

    const newSection = document.createElement("section");
    newSection.setAttribute("data-sohcanv", "workspace");
    newSection.setAttribute("data-sohgroup", "workspace");
    newSection.setAttribute("data-sohno", newNo);
    newSection.textContent = "Body #" + newNo;

    content.appendChild(newSection);
  });
});
