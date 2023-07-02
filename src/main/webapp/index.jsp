<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/widget.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/logo.css">
<link rel="stylesheet" href="css/infobox.css">
<link rel="stylesheet" href="css/toolbar.css">
<link rel="stylesheet" href="css/quick_menu.css">
<link rel="stylesheet" href="css/pwd_changer.css">
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/FindPwd.js"></script>
<script type="text/javascript" src="js/Quick_menu.js"></script>

<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<div class="toolbar">
		<div class="toolbar-info">
			<!-- <ul class="toolbar_nav">
				<li><a href="#">메인</a></li>
				<li><a href="#">여행</a></li>
				<li><a href="#">숙소</a></li>
				<li><a href="#">음식</a></li>
				<li><a href="#">렌트카</a></li>
				<li><a href="#">전통술</a></li>
				<li><a href="#">돌하르방</a></li>
			</ul> -->
			<div class="time"></div>
			<div class="icon"></div>
			<div class="temp"></div>
			<!-- 퀵버튼 -->
			<jsp:include page="${loginPage }"></jsp:include>
			<!-- 로그인버튼 -->
		</div>
	</div>
	<div class="page1_main">
		<section class='section' id='section2'></section>
		<!-- 로그인창 -->
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
					<a id="findPwd_btn" href="#pwd_Changer_Popup">Forgot Password?</a><br> <a
						href="SignUp.jsp">Join to us</a>
				</div>
			</div>
		</div>
		<!-- 로그인창 끝 -->

		<div class="dim" id="dim"></div>


		<!-- 퀵메뉴 -->
		<div class="quick_menu" id="quick">
			<h2>Quick Menu</h2>
			<br>
			<div class="quick-area" id="quick-popup">
				<div class="quick_icon">
					<img class="quick_icon_img" src="css/img/rentcar.png"> <span>렌트카</span>
				</div>
				<div class="quick_icon">
					<img class="quick_icon_img" src="css/img/hostel.png"> <span>숙박</span>
				</div>
				<div class="quick_icon">
					<img class="quick_icon_img" src="css/img/gyul.png"> <span>음식</span>
				</div>
				<div class="quick_icon">
					<img class="quick_icon_img" src="css/img/beach.png"> <span>여행</span>
				</div>
				<div class="quick_icon">
					<img class="quick_icon_img" src="css/img/sul.png"> <span>전통주</span>
				</div>
				<div class="quick_icon">
					<img class="quick_icon_img" src="css/img/grandfa.png"> <span>돌하르방</span>
				</div>
			</div>
		</div>
		<!-- 퀵메뉴 끝 -->
		
		<!-- 비밀번호 변경창 시작 -->
		<div class="pwd_Changer_Popup" id="pwd_Changer_Popup">
		<form action="FindPwdC" method="post" onsubmit="return FindPwdCheck()">
		<h1>Pwd Change</h1>
		<div class="item1-change">ID</div>
		<div class="item2-change">
						<input id="find_pwd_id" name="find_pwd_id"
							placeholder="아이디를 입력하세요" class=""
							autocomplete="off">
							<div id="idError" class="error"></div>
					</div>
					<div class="items-change-question">
					<div class="item1-change-question">Question</div>
					<br>
					<div class="item2-change" id="question">
						<select id="question_selectbox" name="question">
							<option value="1">당신이 가장 좋아하는 색깔은?</option>
							<option value="2">당신의 보물 1호는?</option>
						</select>
						<div class="answer">
							<input class="textInput-reg" type="text" name="userAnswer"
								id="userAnswer" autocomplete="off" placeholder="질문에 대한 답변">
								<div id="answerError" class="error"></div>
						</div>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-change">New PW</div>
					<div class="item2-change">
						<input id="newPwd" type="password" name="newPwd"
							placeholder="영,숫자,특문 포함 8글자 이상" class="textInput-reg"
							autocomplete="off">
						<div id="pwError" class="error"></div>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-change">PW Confirm</div>
					<div class="item2-change">
						<input id="newPwdCheck" type="password" name="newPwdCheck"
							placeholder="비밀번호 재확인" class="textInput-reg" autocomplete="off">
						<div id="pwCheckError" class="error"></div>
					</div>
				</div>
				<br>
				<br>
				<div class="btns-area">
				 <button class="changeConfirm_btn" id="Confirm_btn" type="submit">Confirm</button>
					</div>
		</form>
	</div>
	<!-- 비밀번호 변경창 종료 -->
		<div class="dim2" id="dim2"></div>

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
					<h2>Stay</h2>
				</div>
			</div>
			<div class="box_setup2">
				<div class="infobox3 infobox_hover">
					<h2>Travel</h2>
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

<!-- 로그인실패 알람 표시 -->
<%
String errorMessage = (String) request.getAttribute("errorMessage");
%>
<%
if (errorMessage != null) {
%>
<script>
            alert("<%=errorMessage%>");
        </script>
<%
}
%>
<!-- 비밀번호 변경 실패시 알람 -->
<%
String errorMessage2 = (String) request.getAttribute("errorMessage2");
%>
<%
if (errorMessage2 != null) {
%>
<script>
            alert("<%=errorMessage2%>");
        </script>
<%
}
%>
<!-- 비밀번호 변경 성공시 알람 -->
<%
String errorMessage3 = (String) request.getAttribute("errorMessage3");
%>
<%
if (errorMessage3 != null) {
%>
<script>
            alert("<%=errorMessage3%>");
        </script>
<%
}
%>
