/*리뷰 작성 모달창*/
 function hmOpenReviewWrite(pk,title) {
	console.log(title)
    var modal = document.getElementById("hmReviewWrite");
   	let pk2 = document.querySelector("input[name='hm_r_pk']");
   	let title2 = document.querySelector("input[name='hm_r_title']");
    pk2.value = pk;
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

