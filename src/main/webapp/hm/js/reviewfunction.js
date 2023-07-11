/*리뷰 작성 모달창*/
 function hmOpenReviewWrite(cid,title) {
	console.log(title);
    var modal = document.getElementById("hmReviewWrite");
   	let cid2 = document.querySelector("input[name='hm_r_cid']");
   	let title2 = document.querySelector("input[name='hm_r_title']");
    cid2.value = cid;
    title2.value = title;
    
    modal.style.display = "flex"; // 모달 창을 보이도록 설정
  }

  function hmCloseReviewWrite() {
    var modal = document.getElementById("hmReviewWrite");
    modal.style.display = "none"; // 모달 창을 숨김
  }
  
  
/*리뷰 모달창*/
 function hmOpenReview() {
    var modal = document.getElementById("hmReview");
    modal.style.display = "flex"; // 모달 창을 보이도록 설정
  }

  function hmCloseReview() {
    var modal = document.getElementById("hmReview");
    modal.style.display = "none"; // 모달 창을 숨김
  }


/*리뷰가 삭제 되었음을 알림*/

function confirmDelete() {
	var confirmation = confirm("정말로 삭제하시겠습니까?"); // 삭제 확인 메시지

	if (confirmation) {
		alert("삭제가 완료되었습니다."); // 삭제 완료 알림 메시지
		return true; // 양식 제출(삭제) 수행
	} else {
		return false; // 양식 제출(삭제) 취소
	}
}





