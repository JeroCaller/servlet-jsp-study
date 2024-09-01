const select = document.querySelector("select");
const imageTag = document.querySelector("img");

let imageRootPath = "images/profile/";

imageTag.setAttribute("src", imageRootPath + select.value);
select.addEventListener("change", () => {
	imageTag.setAttribute("src", imageRootPath + select.value);
});