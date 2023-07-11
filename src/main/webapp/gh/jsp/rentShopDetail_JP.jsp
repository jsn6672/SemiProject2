<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input name="gh_lang" value="jp" hidden="">
	<div class="gh-detail">
		<h1>${r.placeName }</h1>
		<div>レビュー平均: ${r.gradeAvg } レビュー数: ${r.gradeCnt }</div>
		<br>
		<div>道路名住所: ${r.addressDoro }</div>
		<div>地番住所: ${r.addressJibun }</div>
		<div>
			カカオマップ URL: <a href="${r.placeUrl }">${r.placeUrl }</a>
		</div>
		<br>
		<!-- ---------------------지도 api------------------------ -->
		<div id="gh_map" style="width: 650px; height: 450px;"></div>
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d985c8f29bf60c804d514f9e452ce826"></script>
		<script>
		var container = document.getElementById('gh_map');
		var options = {
			center: new kakao.maps.LatLng(${r.latitude}, ${r.longitude}),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		var mapContainer = document.getElementById('gh_map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(${r.latitude}, ${r.longitude}), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };


	// 마커가 표시될 위치입니다 
	var markerPosition  = new kakao.maps.LatLng(${r.latitude}, ${r.longitude}); 

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});

	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
	
	 // 인포윈도우로 장소에 대한 설명을 표시합니다
    var infowindow = new kakao.maps.InfoWindow({
        content: '<div style="width:150px;text-align:center;padding:6px 0; border:none; border-radius:10px;">${r.placeName}</div>'
    });
    infowindow.open(map, marker);

	// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
	// marker.setMap(null);  
			</script>
		<!-- ---------------------------------------------------- -->
	</div>
		<br>

	<form action="RentShopDetailC" method="post" enctype="multipart/form-data">
		<div class="gh-write-review">
		<input name="rentShopNo" value="${r.placeNo}" hidden="">
		<input name="listp" value="${curPageNo }" hidden="">
		点数 <select name="rentGrade">
				<option value="1">★
				<option value="2">★★
				<option value="3">★★★
				<option value="4">★★★★
				<option value="5">★★★★★
			</select>
			<textarea class="gh-review-car" name ="rentCar" rows="" cols="" maxlength="100"
				placeholder="車種を入力してください。(最大 100字)"></textarea>
			<br>
			<textarea class="gh-review-write" name="rentReview" rows="" cols="" maxlength="500"
				placeholder="レビューを入力してください。(最大 500字)"></textarea>
			<br>
			<input type="file" name="rentImg">
			<button>登録</button>
		</div>
	</form>


	<div class="gh-rent-reviews">
		<c:forEach items="${rentReviews}" var="rv">
			<div class="gh-review">
				<br>
				<div>${rv.rentId }</div>
				<div><c:choose>
          <c:when test="${rv.rentGrade == 1}">
            <span class="gh-star">★</span>
          </c:when>
          <c:when test="${rv.rentGrade == 2}">
            <span class="gh-star">★★</span>
          </c:when>
          <c:when test="${rv.rentGrade == 3}">
            <span class="gh-star">★★★</span>
          </c:when>
          <c:when test="${rv.rentGrade == 4}">
            <span class="gh-star">★★★★</span>
          </c:when>
          <c:when test="${rv.rentGrade == 5}">
            <span class="gh-star">★★★★★</span>
          </c:when>
        </c:choose> / ${rv.rentDate }</div>
				<div><img style="max-width: 300px; height: auto;" alt="" src="gh/gh_filefolder/${rv.rentImg }"> </div>
				<div>차종: ${rv.rentCar }</div>
				<div>${rv.rentReview }</div>
				<br>
				<hr>
			</div>
		</c:forEach>
	</div>
	
	<div class="pageInfo">
		<a class="gh-review-page-a" value="1"> [1ページ] </a>
		<c:forEach begin="1" end="${totalReviewPage }" var="i">
			<a class="gh-review-page-a" value="${i}" >[${i }]</a>
		</c:forEach>
		<a class="gh-review-page-a" value="${totalReviewPage }"> [最後のページ] </a>
	</div>

</body>


















</body>
</html>