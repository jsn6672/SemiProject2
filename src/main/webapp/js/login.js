// 팝업 열기
function openPopup() {
	var popup = document.getElementById("signup");
	var dim = document.getElementById("dim");
	popup.style.display = "block";
	dim.style.display = "block";
}

// 팝업 닫기
function closePopup() {
	var popup = document.getElementById("signup");
	var dim = document.getElementById("dim");
	popup.style.display = "none";
	dim.style.display = "none";
}

function loginPopup() {
	var loginPopupBtn = document.getElementById("login_Popup_btn");
	var dim = document.getElementById("dim");

	// 로그인 버튼 클릭 시 팝업 열기
	loginPopupBtn.addEventListener("click", openPopup);

	// dim 클릭 시 팝업 닫기
	dim.addEventListener("click", closePopup);
}

// 페이지 로드 
window.addEventListener("load", loginPopup);







