/*리뷰 작성 모달창*/
 function hmOpenReviewWrite(cid,title) {
	console.log(title);
    var modal = document.getElementById("hmReviewWrite");
   	let cid2 = document.querySelector("#modal_cid");
   	let title2 = document.querySelector("#modal_title");
   	alert(cid2);
   	alert(title2);
    cid2.value = cid;
    title2.value = title;
    
    modal.style.display = "block"; // 모달 창을 보이도록 설정
  }

  function hmCloseReviewWrite() {
    var modal = document.getElementById("hmReviewWrite");
    modal.style.display = "none"; // 모달 창을 숨김
  }
  
  
  
  
  
/*리뷰 모달창*/
 function hmOpenReview() {
    var modal = document.getElementById("hmReview");
    modal.style.display = "block"; // 모달 창을 보이도록 설정
  }

  function hmCloseReview() {
    var modal = document.getElementById("hmReview");
    modal.style.display = "none"; // 모달 창을 숨김
  }

