<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f6d7d797f4c680fd25e3195c23d98ca"></script>
</head>
<body>
	<form action="roomSearchC">
		<input name="hotelsearch" type="text">
		<button>검색</button>
	</form>

	<br>

	<div class="container_hm">
		<c:forEach items="${hotels }" var="h">
			<div class="hotel_list" >
				<div class="hotel_img">
					<img alt="" src="${h.r_imgpath }">
				</div>

				<div class="hotel_info">
					<div class="room_title">${h.r_title }</div>
					<div>
						<p>${h.r_roadaddress }</p>
					</div>
					<button name="clickhotel">위치 찾기</button>
					
				</div>
			</div>
						
		</c:forEach>

		<hr>

		<div id="hm_map"></div>
	</div>
		<script>
			var mapContainer = document.getElementById('hm_map'); //지도에 표기할 dv
			var mapOptions = {
				center : new kakao.maps.LatLng(33.3617, 126.5292), //지도 중심 좌표
				level : 9
			};

			var map = new kakao.maps.Map(mapContainer, mapOptions); //객체 생성

			var marker = new kakao.maps.Marker({
				position : new kakao.maps.LatLng(37.5665, 126.9780), // 마커의 위치 좌표
				map : map
			// 마커를 표시할 지도 객체
			});

			map.setMaxLevel(9);
			map.setMinLevel(3);
		</script>
	
	
</body>
</html>