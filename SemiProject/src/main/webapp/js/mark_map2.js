var map;
var marker; // 추가: 이전 마커를 저장하기 위한 변수

let place = document.getElementById('place')?.value;

function moveToLocationByAddress(roadaddress) {
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 이전 마커가 존재한다면 제거합니다
	if (marker) {
		marker.setMap(null);
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

	



		// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		map.panTo(coords);
	}
	map.setMaxLevel(9);
	map.setMinLevel(3);
});