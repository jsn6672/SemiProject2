var map;
var overlays = [];
var markers = [];

// 지도 초기화 함수입니다.
function initMap() {
	var mapOption = {
		center: new kakao.maps.LatLng(33.3616666, 126.5291666),
		level: 3
	};

	// 지도를 생성합니다.
	map = new kakao.maps.Map(document.getElementById('map'), mapOption);
}

// 지도의 위치를 이동시키는 함수입니다.
function moveToLocationByAddress(roadaddress, introduction, imgpath, contentsid) {
	var geocoder = new kakao.maps.services.Geocoder();

	geocoder.addressSearch(roadaddress, function(result, status) {
		if (status === kakao.maps.services.Status.OK) {
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			// 기존의 오버레이와 마커를 제거합니다.
			removeOverlays();

			// 이동한 위치에 마커와 오버레이를 추가합니다.
			addMarkerAndOverlay(result[0].y, result[0].x, roadaddress, introduction, imgpath, contentsid);
			console.log('1 ---' + contentsid);
			// 맵의 중심 위치를 변경합니다.
			map.setCenter(coords);
		}
	});
}

// 지도에 마커와 커스텀 오버레이를 추가하는 함수입니다.
function addMarkerAndOverlay(lat, lng, roadaddress, introduction, imgpath, contentsId) {
	var marker = new kakao.maps.Marker({
		map: map,
		position: new kakao.maps.LatLng(lat, lng)
	});

	// 오버레이 생성 코드입니다.
	var content =
		'<div class="overlay-wrap">' +
		'    <div class="overlay-info">' +
		'        <div class="overlay-img">' +
		'            <img src="' + imgpath + '" class="overlay-img-src">' +
		'        </div>' +
		'        <div class="overlay-body">' +
		'            <div class="overlay-title">' + roadaddress + '</div>' +
		'            <div class="overlay-desc">' +
		'                <div>' + introduction + '</div>' +
		'                <div><a href="#" id="homepage_link" class="link">리뷰쓰기</a></div>' +
		'                <div><button class="close">Close</button></div>' +
		'            </div>' +
		'        </div>' +
		'    </div>' +
		'</div>';


	console.log('2 ---' + contentsId);
	var overlay = new kakao.maps.CustomOverlay({
		content: content,
		map: null,
		position: marker.getPosition()
	});

	overlays = [overlay];
	markers = [marker];

	// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다.
	kakao.maps.event.addListener(marker, 'click', function() {
		overlay.setMap(map);



		setTimeout(function() {
			var closeBtn = document.querySelector('.close');
			closeBtn.onclick = function() {
				overlay.setMap(null);
				closeOverlay(overlays.indexOf(overlay));
			};
			// 이 부분에 모달 창을 띄우는 로직을 추가합니다.
			var homepageLink = document.querySelector('#homepage_link');
			homepageLink.onclick = function(e) {
				e.preventDefault(); // 기본 링크 동작을 막습니다.
				console.log('Click event triggered!'); // 이 문장을 추가합니다.
				openModal(contentsId); // 모달 창을 띄우는 함수를 호출합니다.
			};
		}, 0);


		//	var closeBtn = overlay.getContent().querySelector('.close');
		//		closeBtn.addEventListener('click', function() {
		//			closeOverlay(overlays.indexOf(overlay));
		//		});
	});
	window.onload = function() {
		let secondBtn = document.querySelector('.btn-secondary');
		let button1Handler = bootstrapHandler(secondBtn, function(event) {
			console.log('Button 1 was clicked!');
		});
		secondBtn.addEventListener("click", button1Handler)

	};


}
function openModal(contentsId) {
	console.log('openModal function called!');
	$('#myModal').modal('show');

// 모달 창이 열릴 때 발생하는 이벤트 핸들러 등록
$('#myModal').on('shown.bs.modal', function() {
	// 인풋 창 보이도록 설정
	$('#r_title').show();
	$('#r_content').show();
	$('#r_score').show();
	console.log('3 ---' + contentsId);
	console.log($("#r_contentsId"))
	$("#r_contentsId").val(contentsId);
});


// 모달 창이 닫힐 때 발생하는 이벤트 핸들러 등록
$('#myModal').on('hidden.bs.modal', function() {
	// 인풋 창 숨기도록 설정
	$('#r_title').hide();
	$('#r_content').hide();
	$('#r_score').hide();
});
}
function closeOverlay(index) {
	if (overlays[index]) {
		overlays[index].setMap(null);
		overlays.splice(index, 1);
	}
}

// 기존의 오버레이와 마커를 제거하는 함수입니다.
function removeOverlays() {
	for (var i = 0; i < overlays.length; i++) {
		overlays[i].setMap(null);
	}

	for (var i = 0; i < markers.length; i++) {
		markers[i].setMap(null);
	}

	overlays = [];
	markers = [];
}




// 지도 초기화를 실행합니다.
initMap();

// 원하는 주소로 지도의 위치를 이동시킵니다.
moveToLocationByAddress("제주특별자치도 제주시 첨단로 242", "소개글", "이미지 URL");
