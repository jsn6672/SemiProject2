// 퀵 팝업 열기
function openQuick() {
  let quick = document.getElementById("quick");
  quick.style.display = "block";
}

// 퀵 팝업 닫기
function closeQuick() {
  let quick = document.getElementById("quick");
  quick.style.display = "none";
}

// 문서 로드 후 이벤트 등록
document.addEventListener("DOMContentLoaded", function() {
  let quickPopupBtn = document.getElementById("quick_Popup_btn");
  let quickPopup = document.getElementById("quick");

  // 퀵 팝업 열기
  quickPopupBtn.addEventListener("click", openQuick);

  // 외부 클릭 시 퀵 팝업 닫기
  document.addEventListener("click", function(event) {
    if (event.target !== quickPopupBtn && !quickPopup.contains(event.target)) {
      closeQuick();
    }
  });
});