


function mapMake(place, name, img) {
	var mapContainer = document.getElementById('map');
	var mapOption = {
		center: new kakao.maps.LatLng(33.450701, 126.570667),
		level: 9
	};
	var map = new kakao.maps.Map(mapContainer, mapOption);

	var geocoder = new kakao.maps.services.Geocoder();

	geocoder.addressSearch(place, function(result, status) {
		if (status === kakao.maps.services.Status.OK) {
			console.log("검색 성공");
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			var marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});
			// 마커이미지 표시							
			var markerImage = document.getElementById('markerImage');
			markerImage.src = img;
			markerImage.style.display = 'block';

			var infowindow = new kakao.maps.InfoWindow({
				content: '<div style="width:150px;text-align:center;padding:6px 0;"><img src="' + markerImage.src + '" style="width:100%;height:auto;"><br>' + name + '</div>'
			});

			infowindow.open(map, marker);

			map.setCenter(coords);
		}
	});
}

window.onload = function() {
	mapMake('${g.addr}', '${g.name}', '${g.img}');
};






let reviewBtns = document.querySelectorAll('.review-btn');
reviewBtns.forEach((reviewBtn) => {
	reviewBtn.addEventListener("click", function(e) {
		let reviewWrap = e.target.parentNode.nextElementSibling;
		console.log(reviewWrap.style.display);
		if (reviewWrap.style.display == "none" || reviewWrap.style.display == "") {
			reviewWrap.style.display = "block";
		}else{
			reviewWrap.style.display = "none";
		}

	});
});




/*리뷰 작성 모달창*/
function sjOpenReviewWrite(id) {
	
	var modal = document.getElementById("sjReviewWrite");
	let id_input = document.querySelector('input[name="g_id_s"]');
	id_input.value = id;
	modal.style.display = "block"; // 모달 창을 보이도록 설정

	document.getElementById("review-modal-form").addEventListener("submit", function(event) {
  	event.preventDefault(); // 폼 제출 이벤트의 기본 동작(페이지 새로고침)을 막습니다.
	console.log(document.getElementById("review-modal-form"))
  // Ajax 요청을 처리하는 코드를 작성합니다.
  var form = document.getElementById("review-modal-form");
  var formData = new FormData(form);

  var xhr = new XMLHttpRequest();
  xhr.open("POST", "GourmetReviewC", true);
  xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
      // 요청이 성공적으로 완료되었을 때의 처리 코드
		window.reload();
    }
  };
  xhr.send(formData);
 	
});	
	
	
	
	
	
}

function sjCloseReviewWrite() {
	var modal = document.getElementById("sjReviewWrite");
	modal.style.display = "none"; // 모달 창을 숨김
}


function deleteReview(no, pw) {

	var inputPassword = prompt("비밀번호를 입력하세요:");

	if (inputPassword === pw) {
		location.href = 'GourmetReviewDelC?no=' + no;
	} else {
		alert("비밀번호가 틀렸습니다.");
	}
}







