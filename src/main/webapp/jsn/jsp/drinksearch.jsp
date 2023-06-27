<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="jsn/css/drinkdetail.css">
<script type="text/javascript" src="jsn/js/starpoint.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<button
		onclick="location.href='DrinkDetailC?no=${drink_detail.t_no}&language=1&listp=${curListPageNo }'">번역</button>
	<button onclick="location.href='JsnHC'">뒤돌</button>
	<div
		style="display: flex; align-items: flex-start; text-align: center;">
		<div class="drink-list" style="flex-basis: 15%; text-align: center;">
			<form action="DrinkSearchC">
				<div>
					<input name="listp" value="${curListPageNo }" hidden=""> <select
						name="type">
						<option value="drinkname">전통주</option>
						<option value="brewername">양조장</option>
					</select> <input name="name">
					<button>검색</button>
				</div>
			</form>
			<c:forEach items="${drink }" var="d">
				<c:choose>
					<c:when test="${d.t_no == drink_detail.t_no }">
						<div
							style="text-align: center; height: 70px; background-color: rgb(242, 242, 247); border-radius: 15%; width: 150px;">
							<a
								href="DrinkSearchDetailC?no=${d.t_no }&language=2&listp=${curListPageNo}">${d.t_name }
								<br>${d.t_market } <br>★ : ${d.t_avgscore/2 }
							</a>
						</div>
					</c:when>
					<c:otherwise>
						<div style="height: 70px;">
							<a
								href="DrinkSearchDetailC?no=${d.t_no }&language=2&listp=${curListPageNo}">${d.t_name }<br>${d.t_market }<br>평점
								: ${d.t_avgscore/2 }
							</a>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<div>
				<a href="DrinkSearchListPageC?listp=1&no=${drink_detail.t_no }">[맨처음]</a>
				<c:forEach begin="1" end="${listPageCount }" var="i">
					<a href="DrinkSearchListPageC?listp=${i }&no=${drink_detail.t_no }">
						[${i }] </a>
				</c:forEach>
				<a
					href="DrinkSearchListPageC?listp=${listPageCount }&no=${drink_detail.t_no }">[맨
					끝]</a>
			</div>
		</div>
		<div class="drink-detail-content"><jsp:include
				page="${detailPage }"></jsp:include></div>
	</div>
</body>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=50fa30c5003d50ab611f3775819b8a8b&libraries=services"></script>
<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(33.392143993983, 126.49391202401), // 지도의 중심좌표
		level : 3
	// 지도의 확대 레벨
	};

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	geocoder
			.addressSearch(
					'${kraddr}',
					function(result, status) {

						// 정상적으로 검색이 완료됐으면 
						if (status === kakao.maps.services.Status.OK) {

							var coords = new kakao.maps.LatLng(result[0].y,
									result[0].x);

							// 결과값으로 받은 위치를 마커로 표시합니다
							var marker = new kakao.maps.Marker({
								map : map,
								position : coords
							});

							// 인포윈도우로 장소에 대한 설명을 표시합니다
							var infowindow = new kakao.maps.InfoWindow(
									{
										content : '<div style="width:150px;text-align:center;padding:6px 0;">${brewer.b_name}</div>'
									});
							infowindow.open(map, marker);

							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});
</script>
</html>