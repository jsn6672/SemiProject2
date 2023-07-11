<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="sj/gourmetcss/gourmet.css">
<!--  <link rel="stylesheet" type="text/css" href="sj/gourmetcss/gourmetToolbar.css">-->
<link rel="stylesheet" type="text/css" href="css/toolbar.css">
<link rel="stylesheet" type="text/css" href="css/widget.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/quick_menu.css">
<script type="text/javascript" src="js/login.js"></script>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=85af9840b8713b35481bb6ab8c998933&libraries=services"></script>
<style type="text/css">
body {
	height: 2500px;
}
</style>
</head>
<body>

	<div class="toolbar">
		<div class="toolbar-info">
			<ul class="toolbar_nav">
				<li><a href="tourC">여행</a></li>
				<li><a href="roomAllsearchC">숙소</a></li>
				<li><a href="GourmetC">음식</a></li>
				<li><a href="RentShopC">렌트카</a></li>
				<li><a href="JsnHC">전통술</a></li>
			</ul>
			<div class="time"></div>
			<div class="icon"></div>
			<div class="temp"></div>
			<a href="Main_HC" class="quick_btn">홈</a> <br> <a
				href="GourmetJPC" class="quick_btn">日本語</a> <br>
			<!-- 퀵버튼 -->
			<jsp:include page="${loginPage }"></jsp:include>
			<!-- 로그인버튼 -->
		</div>
	</div>
	<div class="popup" id="signup">
		<div class="sign_up">
			<h1 class="signup_header">안녕, 육지사람 :-)</h1>
			<br>
			<form action="loginC" method="post">
				<div class="int-area">
					<label for="id">USER ID</label> <input type="text" name="id"
						id="login_id" autocomplete="off">
				</div>
				<div class="int-area">
					<label for="id">USER PW</label> <input type="password" name="pw"
						id="login_pw" autocomplete="off">
				</div>
				<div class="btn-area">
					<button class="loginConfirm_btn" id="btn" type="submit">LOGIN</button>
				</div>
			</form>
			<div class="caption">
				<a id="findPwd_btn" href="#pwd_Changer_Popup">Forgot Password?</a><br>
				<a href="SignUp.jsp">Join to us</a>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>




	<div class="container">
		<!-- gourmetResult의 전체 container -->

		<div class="search-wrap">
			<form class="search-form" action="GourmetSearchC" method="post">
				<div class="drink_header">
					<div class="drink_seach_header"></div>
					<select name="type" class="search_select">
						<option value="name">상호</option>
						<option value="location">위치</option>
					</select> <span class="search-icon"></span> <input class="gourmet-search"
						name="input" autocomplete="off">
					<button type="submit" class="search-button">search</button>
				</div>
			</form>
		</div>

		<div class="sj-viewcontainer" style="display: flex;">
			<!-- 결과와 지도를 묶는 div -->
			<div class="sj-result-background">
				<div class="sj-result"
					style="overflow-y: auto; height: 450px; z-index: 999; position: absolute;">
					<!-- 결과 뷰잉 div -->
					<c:forEach var="g" items="${gourmetInfos }" varStatus="status">
						<div class="sj-search-result">
							<br>${g.name }<br> <br> <span
								style="display: none;">${g.id }</span><br> ${g.tel }<br>
							${g.addr }<br> <br> ${g.menu }<br> <input
								id="addr" name="addr" hidden="" value="${g.addr}"> <input
								name="input" hidden="" value="${select}"> <input
								name="select" hidden="" value="${input}">

							<button class="map-btn"
								onclick="mapMake('${g.addr }','${g.name }','${g.img }')">Map</button>
							<%-- 						<button onclick="sjOpenReview('${g.id }')">Review</button>--%>
							<button class="review-btn">Review</button>
							<button class="review-btn" onclick="sjOpenReviewWrite('${g.id}')">Write</button>
						</div>

						<div class="review-div-wrap">
							<c:forEach var="review" items="${g.reviews }">
								<div class="review-div">
									<br>
									<div class="review-a">평 점 : ${review.gm_grade }</div>
									<div class="review-a">작성일자 : ${review.gm_date }</div>
									<div class="review-a">추천메뉴 : ${review.gm_menu }</div>
									<div class="review-a">내 용 : ${review.gm_review }</div>
									<br> <br>
									<button id="delete-btn"
										onclick="deleteReview('${review.gm_no}', '${review.gm_pw }')">delete</button>
									</form>

								</div>



								<div>
									<!-- 바꿈줄 -->
									<br>
									<hr>
								</div>
							</c:forEach>
						</div>

					</c:forEach>
				</div>
				<!-- 검색결과창 바탕div -->
			</div>
			<!-- 결과 뷰잉 페이지 div 끝 -->

			<!-- 결과검색창 및 지도 -->
			<!-- 지도 뷰잉 페이지 div -->
			<!-- 지도를 표시할 div 입니다 -->

			<div id="map">
				<img id="markerImage" src=""
					style="width: 0px; height: 0px; display: none;">
			</div>
		</div>


	</div>
	<!-- 결과와 지도를 묶는 div 끝 -->





	<!-- 리뷰 작성 모달 창 -->
	<div>
		<div id="sjReviewWrite" class="sj-review-write" style="right: 0;">
			<div class="sj-review-content-write">
				<!-- 	<input hidden name="g_id_s" > -->
				<span onclick="sjCloseReviewWrite()" class="sj-close">&times;</span>
				<h2>리뷰를 작성해주세요!</h2>
				<p></p>
				<form action="GourmetReviewC" method="post" id="review-modal-form"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td>평점</td>
							<td><input hidden name="g_id_s"> <select
								name="sj-reviewGrade">
									<option value="1">★</option>
									<option value="2">★★</option>
									<option value="3">★★★</option>
									<option value="4">★★★★</option>
									<option value="5">★★★★★</option>
							</select></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea id="sj-r_text" name="sj-r_text" rows="10"
									cols="65"></textarea></td>
						</tr>
						<tr>
							<td>메뉴</td>
							<td><textarea id="sj-r_menu" name="sj-r_menu" rows="8"
									cols="65"></textarea></td>
						</tr>
						<tr>
							<td>사진</td>
							<td><input name="sj-r_pic" type="file"></td>
						</tr>
						<tr>
							<td>PW</td>
							<td><input id="sj-r_pw" name="sj-r_pw"></td>
						</tr>
						<tr>
							<td><button id="modal-btn" onclick="sjCloseReviewWrite()">Write</button></td>
						</tr>
					</table>
				</form>



			</div>
		</div>
	</div>

	</div>
	<!-- container div 끝 -->




	<script src="https://code.jquery.com/jquery-3.7.0.js"
		integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="sj/gourmetjs/gourmet.js"></script>
	<script>
		$
				.getJSON(
						'https://api.openweathermap.org/data/2.5/weather?q=Jeju City&appid=e4ef05580f862e66fd424cf8275dc13f&units=metric',
						function(result) {
							var temp = Math.round(result.main.temp);
							var wind = result.wind.speed;
							var ct = result.dt;

							function convertTime(t) {
								var week = new Array('일요일', '월요일', '화요일',
										'수요일', '목요일', '금요일', '토요일');
								var days = new Date().getDay();
								var today = week[days];
								var ot = new Date(t * 1000);
								var hr = ot.getHours();
								var m = ot.getMinutes();

								if (hr >= 12 && hr <= 24) {
									return today + ' /' + ' 오후 ' + hr + ' : '
											+ m
								} else {
									return today + ' /' + ' 오전 ' + hr + ' : '
											+ m
								}
							}
							function temps(temp) {
								return temp + '℃'
							}

							function winds(wind) {
								return '풍속 ' + wind + ' m/s'
							}

							var wiconUrl = '<img src="https://openweathermap.org/img/wn/'+result.weather[0].icon+'@2x.png" alt="'+result.weather[0].description+'">'
							$('.icon').html(wiconUrl);
							var currentTime = convertTime(ct);
							$('.time').html(currentTime);
							var currentTemp = temps(temp);
							$('.temp').html(currentTemp);
							var windSpeed = winds(wind);
							$('.wind').html(windSpeed);
						});
	</script>
</body>
</html>