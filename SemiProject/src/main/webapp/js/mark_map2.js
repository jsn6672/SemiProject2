
var map;
var marker; // 추가: 이전 마커를 저장하기 위한 변수
var customOverlay;//오버레이 기능

let place = document.getElementById('place')?.value;

function moveToLocationByAddress(roadaddress, title, introduction, imgpath, tag) {
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 이전 마커가 존재한다면 제거합니다
	if (marker) {
		marker.setMap(null);
	}
	if (customOverlay) {
		customOverlay.setMap(null);
	}
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(roadaddress, function(result, status) {
		// 정상적으로 검색이 완료됐으면 
		if (status === kakao.maps.services.Status.OK) {
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			// 결과값으로 받은 위치를 마커로 표시합니다
			marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});

			// 커스텀 오버레이를 생성합니다
			var content = '<div class="wrap">' +
				'    <div class="info">' +
				'        <div class="title">' + title +
				'            <div class="close" onclick="closeOverlay()" title="닫기"></div>' +
				'        </div>' +
				'        <div class="body">' +
				'            <div class="img">' +
				'                <img src="' + imgpath + '" width="73" height="70">' +
				'           </div>' +
				'            <div class="desc">' +
				'                <div class="ellipsis">' + roadaddress + '</div>' +
				'                <div class="jibun ellipsis">' + introduction + '</div>' +
				'                <div class="tag">' + tag + '</div>' +
				'            </div>' +
				'        </div>' +
				'    </div>' +
				'</div>';

			customOverlay = new kakao.maps.CustomOverlay({
				position: coords,
				content: content,
				xAnchor: 0.5,
				yAnchor: 1.0
			});

			// 커스텀 오버레이를 지도에 표시합니다
			customOverlay.setMap(map);


			// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			map.setCenter(coords);
		}
	});
}

function initMap() {
	var mapOption = {
		center: new kakao.maps.LatLng(33.3617, 126.5292),
		level: 9
	};

	map = new kakao.maps.Map(document.getElementById('hm_map'), mapOption);
}

initMap();

// 지도 부드럽게 움직이기
var geocoder = new kakao.maps.services.Geocoder();

geocoder.addressSearch(place, function(result, status) {
	// 정상적으로 주소의 좌표를 검색했다면
	if (status === kakao.maps.services.Status.OK) {
		var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		// 결과값으로 받은 위치를 마커로 표시합니다
		marker = new kakao.maps.Marker({
			map: map,
			position: coords
		});

		// 커스텀 오버레이를 생성합니다
		var content = '<div class="wrap">' +
			'    <div class="info">' +
			'        <div class="title">' +
			'            ' +
			'            <div class="close" onclick="closeOverlay()" title="닫기"></div>' +
			'        </div>' +
			'        <div class="body">' +
			'            <div class="img">' +
			'                <img src="https://cfile181.uf.daum.net/image/250649365602043421936D" width="73" height="70">' +
			'           </div>' +
			'            <div class="desc">' +
			'                <div class="ellipsis">제주특별자치도 제주시 첨단로 242</div>' +
			'                <div class="introduction">(우) 63309 (지번) 영평동 2181</div>' +
			'                <div><a href="https://www.kakaocorp.com/main" target="_blank" class="link">홈페이지</a></div>' +
			'            </div>' +
			'        </div>' +
			'    </div>' +
			'</div>';


		customOverlay = new kakao.maps.CustomOverlay({
			position: coords,
			content: content,
			xAnchor: 0.5,
			yAnchor: 1.0
		});

		// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		map.panTo(coords);

		// 커스텀 오버레이를 지도에 표시합니다
		customOverlay.setMap(map);
	}


	map.setMaxLevel(9);
	map.setMinLevel(3);
});