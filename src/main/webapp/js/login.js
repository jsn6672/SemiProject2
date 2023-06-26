let showPopupBtn = document.getElementById("login_Popup_btn");
let popup = document.getElementById("signup");
let dim = document.getElementById("dim")

showPopupBtn.addEventListener("click", function() {
	popup.style.display = "block";
});

document.addEventListener("click", function(event) {
	if (popup.style.display === "block" && !popup.contains(event.target)) {
		popup.style.display = "none";
		dim.style.display = "none";
	}
});
