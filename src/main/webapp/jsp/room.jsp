<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<div id="hm_map" style="width: 80%; height: 800px;"></div> 
k=""></div>	

	<="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f6d7d797f4c680fd25e3195c23d98ca"></script>
	<script>
		var mapContainer = document.getElementById('hm_map'); //지도에 표기할 dv
		var mapOptions = {
			center : new kakao.maps.LatLng(33.3617, 126.5292), //지도 중심 좌표
			level : 9	/*지도 확대 레벨  */
		};
	

		var map = new kakao.maps.Map(mapContainer, mapOptions); //객체 생성
		
		   var marker = new kakao.maps.Marker({
	            position: new kakao.maps.LatLng(37.5665, 126.9780), // 마커의 위치 좌표
	            map: map // 마커를 표시할 지도 객체
	        });
		
		   map.setMaxLevel(9);
		   map.setMinLevel(3);
		</script>
	  
</body>
</html>