<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="gh/css/rentShop.css">
<link rel="stylesheet" type="text/css" href="css/toolbar.css">
<link rel="stylesheet" type="text/css" href="css/widget2.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/quick_menu.css">
<script type="text/javascript" src="js/login.js"></script>
<style type="text/css">
.toolbar_nav li {
	text-decoration: none;
	float: left;
	padding: 0 70px;
	line-height: 80px;
	font-size: 20px;
	list-style-type: none;
	width: 180px;
	height: 70px;
	text-align: center;
}
</style>
</head>
<body>
	<input name="gh_lang" value="jp" hidden="">
	<div class="toolbar">
		<div class="toolbar-info">
			<ul class="toolbar_nav">
				<li><a href="tourC">観光地</a></li>
				<li><a href="roomAllsearchC">宿泊</a></li>
				<li><a href="GourmetC">食堂</a></li>
				<li><a href="RentShopC">レンタカー</a></li>
				<li><a href="JsnHC">伝統酒</a></li>
			</ul>
			<div class="time"></div>
			<div class="icon"></div>
			<div class="temp"></div>
			<a href="Main_HC" class="quick_btn">ホーム</a> <br>
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
	<div class="gh-container">
		<br> <br> <br> <br>
		<!-- <h1>
		<a href="RentShopC"> 렌터카 검색 </a>
	</h1> -->
		<div class="gh-search">
			<form action="RentShopSearchC">
				<select name="searchOption">
					<option value="placeName">場所名</option>
					<option value="addressDoro">住所（道路名）</option>
					<option value="addressJibun">住所（地番）</option>
				</select> <input name="searchText">
				<!-- 	<input type="hidden" name="no" value="${no}">  -->
				<button class="gh-search-button">検索</button>
			</form>

			<form action="RentShopC">
				<button class="gh-translate">한국어</button>
			</form>

			<!-- DB 넣는 용도로 썼던 버튼(사용X) -->
			<!-- <form action="X_InsertShopC">
				<button>db insert</button>
			</form> -->
			<!-- JP DB 넣는 용도로 썼던 버튼(사용X) -->
			<!-- <form action="gh_JPC">
				<button>jp db insert</button>
			</form> -->

		</div>


		<div class="gh-content">
			<div style="display: flex;">
				<div class="gh-contentPage">
					<jsp:include page="${contentPage }"></jsp:include>
				</div>
				<div class="gh-detailPage">
					<jsp:include page="${detailPage }"></jsp:include>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	let params = (new URL(document.location)).searchParams;
	let listP = params.get('listp');
	let reviewP = params.get('reviewp');
	let no = params.get('no');
	if( no == null){
		no = ${no};
	}
	console.log(no);
	if (listP == null) listP = 1; 
	if (reviewP == null) reviewP = 1; 
	const reviewATag = document.querySelectorAll('.gh-review-page-a');
	const listATag = document.querySelectorAll('.list-page-a');
	reviewATag.forEach((reviewA) => {
		reviewA.addEventListener("click", function() {
		let url = "RentPagingC?";
		console.log(reviewA.getAttribute("value"));
		console.log('만든 url로 요청이  review + list');
		url += "reviewp=" + reviewA.getAttribute("value") + "&listp="+listP + "&no=" + no;
		reviewA.href = url;		
			});
	 });
	listATag.forEach((listA) => {
		listA.addEventListener("click", function() {
		let url = "RentPagingC?";
		url += "reviewp=" + reviewP + "&listp="+ listA.getAttribute("value") + "&no=" + no;
		listA.href = url;		
		console.log('만든 url로 요청이  list + review');
			});
	 });
</script>
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
							var week = new Array('日曜日', '月曜日', '火曜日', '水曜日',
									'木曜日', '金曜日', '土曜日');
							var days = new Date().getDay();
							var today = week[days];
							var ot = new Date(t * 1000);
							var hr = ot.getHours();
							var m = ot.getMinutes();

							if (hr >= 12 && hr <= 24) {
								return today + ' /' + ' 午後 ' + hr + ' : ' + m
							} else {
								return today + ' /' + ' 午前 ' + hr + ' : ' + m
							}
						}
						function temps(temp) {
							return temp + '℃'
						}

						function winds(wind) {
							return '風速 ' + wind + ' m/s'
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