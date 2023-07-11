<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="hm/css/hm.css">


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
	<br>
	<br>
	<br>
	<br>
	

	<table id="site" >
		<tr>
			<td><jsp:include page="${contentPage }"></jsp:include></td>
		</tr>
	</table>
	
	
<script type="text/javascript" src="js/reviewfunction.js"></script>

<!-- Jquery 받아오기 -->
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>

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








</body>
</html>
