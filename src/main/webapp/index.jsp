<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/widget.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/logo.css">
<link rel="stylesheet" href="css/infobox.css">
<link rel="stylesheet" href="css/toolbar.css">
<link rel="stylesheet" href="css/quick_menu.css">
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="toolbar">
		<div class="toolbar-info">
			<div class="time"></div>
			<div class="icon"></div>
			<div class="temp"></div>
			<a href="#quick" class="quick_btn">quick</a>
			<!-- 퀵버튼 -->
			<br> <a href="#signup" class="login_btn">Login</a>
			<!-- 로그인버튼 -->
		</div>
	</div>
	<div class="page1_main">
		<section class='section' id='section2'></section>
		<!-- 로그인창 -->
		<div class="popup" id="signup">
			<a href="#a">X</a>
			<div class="sign_up">
				<h1 class="signup_header">안녕, 육지사람 :-)</h1>
				<br>
				<form action="" method="post">
					<div class="int-area">
						<label for="id">USER ID</label> <input type="text" name="id"
							id="id" autocomplete="off" required>
					</div>
					<div class="int-area">
						<label for="id">USER PW</label> <input type="password" name="pw"
							id="pw" autocomplete="off" required>
					</div>
					<div class="btn-area">
						<button href="SignUpC" class="login_btn" type="submit" id="btn">LOGIN</button>
					</div>
				</form>
				<div class="caption">
					<a href="SignUpC">Forgot Password?</a><br> <a
						href="SignUp.jsp">Join to us</a>
				</div>
			</div>
		</div>
		<!-- 로그인창 끝 -->

		<div id="dim"></div>


		<!-- 퀵메뉴 -->
		<div class="quick_menu" id="quick">
			<a href="#a">x</a>
			<h2>quick menu</h2>
			<br>
			<form action="">
				<div class="quick-area">
					<div class="quick_icon">
						<img src="css/img/rentcar.png"> &nbsp;&nbsp; <img
							src="css/img/hostel.png">
					</div>
					<div class="quick_icon">
						<img src="css/img/gyul.png"> &nbsp;&nbsp; <img
							src="css/img/beach.png">
					</div>
					<div class="quick_icon">
						<img src="css/img/sul.png"> &nbsp;&nbsp; <img
							src="css/img/grandfa.png">
					</div>
				</div>
			</form>
		</div>


		<div class="logo">
			<div class="logo1">
				<span class="point">올레</span>길을
			</div>
			<div class="logo2">여행하는</div>
			<div class="logo3">
				히치<span class="point">하이</span>커를
			</div>
			<div class="logo4">위한 안내서</div>
		</div>
		<div class="arrow_control">
			<input type="image" id='button1' src="css/img/arrow_down.png" />
			<!-- 페이지 이동 화살표 -->
		</div>
	</div>

	<div class="page2_main">
		<section class='section' id='section1'></section>
		<div class="infobox_main">
			<div class="box_setup1">
				<div class="infobox1 infobox_hover">
					<h1>CarRent</h1>
				</div>
				<div class="infobox2 infobox_hover">
					<h2>Accommodation</h2>
				</div>
			</div>
			<div class="box_setup2">
				<div class="infobox3 infobox_hover">
					<h2>Must to go</h2>
				</div>
				<div class="infobox4 infobox_hover">
					<h1>Food</h1>
				</div>
			</div>
			<div class="box_setup3">
				<div class="infobox5 infobox_hover">
					<h1>Liquor</h1>
				</div>
				<div class="infobox6 infobox_hover">
					<h2>idk yet</h2>
				</div>
			</div>
		</div>
	<div class="arrow_control">
		<input type="image" id='button2' src="css/img/arrow_up.png" />
		<!-- 페이지 이동 화살표 -->
	</div>
	</div>
</body>

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

<script>
/* 스크롤 이동 기능 */
    const button1 = document.getElementById('button1');
    const section1 = document.getElementById('section1');

    button1.addEventListener('click', () => {
        window.scrollBy({top: section1.getBoundingClientRect().top, behavior: 'smooth'});
    });
    const button2 = document.getElementById('button2');
    const section2 = document.getElementById('section2');

    button2.addEventListener('click', () => {
        window.scrollBy({top: section2.getBoundingClientRect().top, behavior: 'smooth'});
    });
</script>

</html>