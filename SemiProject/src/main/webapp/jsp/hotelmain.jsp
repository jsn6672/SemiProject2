<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f6d7d797f4c680fd25e3195c23d98ca&libraries=services"></script>
</head>

<body>

	<form action="roomSearchC">
		<input name="hotelsearch" type="text">
		<button>검색</button>
	</form>

	<br>

	<div class="container_hm">
		<div class="hotel_list">
			<c:forEach items="${hotels }" var="h">
				<div class="hotel_content">

					<div class="hotel_img">
						<img alt="" src="${h.r_imgpath }">
					</div>

					<div class="hotel_info">
						<div class="room_title">${h.r_title }</div>
						<div class="hotel_roadaddress">
							<p>주소 : ${h.r_roadaddress }</p>
						</div>
						<button name="clickhotel" onclick="location.href='roomClickC?place=${h.r_roadaddress }'">위치 찾기</button>
					</div>

				</div>
				<br>
			</c:forEach>
		</div>
		<hr>
		<input type="hidden" id="place" value="${param.place }">
		<div id="hm_map"></div>
	</div>

	<script type="text/javascript" src="js/mapmarking.js">
	</script>

</body>
</html>