<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jsn/js/starpoint.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="jsn/css/drinkdetail.css">
<link rel="stylesheet" href="jsn/css/drinkreview.css">
<link rel="stylesheet" type="text/css" href="css/toolbar.css">
<link rel="stylesheet" type="text/css" href="css/widget.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/quick_menu.css">
<script type="text/javascript" src="js/login.js"></script>

</head>
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
			<!--  <a href="JPC">DB번역</a> -->
			<a class="translate_btn"
				onclick="location.href='DrinkDetailC?no=${drink_detail.t_no}&language=1&listp=${curListPageNo }&reviewp=${curReviewPageNo }'">번역</a>
			<a href="Main_HC" class="quick_btn">홈</a> <br>
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

	<div class="dim" id="dim"></div>
	<br>
	<br>
	<br>
	<br>
	<form action="DrinkSearchC">
		<div class="drink_header">
			<div class="drink_seach_header">
				<input class="drink_search" name="name" autocomplete="off">
				<button class="drink_search_btn"></button>
			</div>
			<input name="listp" value="${curListPageNo }" hidden=""> <select
				name="type" class="search_select">
				<!-- 	<option disabled selected>🍊🍊🍊</option> -->
				<option value="drinkname">전통주</option>
				<option value="brewername">양조장</option>
			</select>
		</div>
	</form>
	<div class="drink-content">
		<div class="drink-list">
			<c:forEach items="${drink }" var="d">
				<c:choose>
					<c:when test="${d.t_no == drink_detail.t_no }">
						<div class="drink-list-attention">
							<a class="drink_list_a"
								href="DrinkDetailC?no=${d.t_no }&language=2&listp=${curListPageNo}">${d.t_name }
								<br>${d.t_market } <br>★ : ${d.t_avgscore/2 }
							</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="drink-list-notattention">
							<a class="drink_list_a"
								href="DrinkDetailC?no=${d.t_no }&language=2&listp=${curListPageNo}">${d.t_name }<br>${d.t_market }<br>★
								: ${d.t_avgscore/2 }
							</a>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<div class="drink-list-page">
				<a href="DrinkListPageC?listp=1&no=${drink_detail.t_no }">[처음]</a>
				<c:forEach begin="1" end="${listPageCount }" var="i">
					<a href="DrinkListPageC?listp=${i }&no=${drink_detail.t_no }">
						[${i }] </a>
				</c:forEach>
				<a
					href="DrinkListPageC?listp=${listPageCount }&no=${drink_detail.t_no }">[끝]</a>
			</div>
		</div>
		<div class="drink_include">
			<jsp:include page="${detailPage }"></jsp:include>
		</div>
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
<!-- Jquery 받아오기 -->
<script src="https://code.jquery.com/jquery-3.7.0.min.js"
	integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
	crossorigin="anonymous">
	
</script>
<script>
	/* 날씨를 받아오자 재환아 */
	$
			.getJSON(
					'https://api.openweathermap.org/data/2.5/weather?q=Jeju City&appid=e4ef05580f862e66fd424cf8275dc13f&units=metric',
					function(result) {
						var temp = Math.round(result.main.temp);
						var wind = result.wind.speed;
						var ct = result.dt;

						function convertTime(t) {
							var week = new Array('일요일', '월요일', '화요일', '수요일',
									'목요일', '금요일', '토요일');
							var days = new Date().getDay();
							var today = week[days];
							var ot = new Date(t * 1000);
							var hr = ot.getHours();
							var m = ot.getMinutes();

							if (hr >= 12 && hr <= 24) {
								return today + ' /' + ' 오후 ' + hr + ' : ' + m
							} else {
								return today + ' /' + ' 오전 ' + hr + ' : ' + m
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
</html>