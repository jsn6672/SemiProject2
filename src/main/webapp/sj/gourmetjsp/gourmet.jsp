<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="sj/gourmetcss/gourmet.css">
<link rel="stylesheet" type="text/css" href="css/toolbar.css">
<link rel="stylesheet" type="text/css" href="css/widget.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/quick_menu.css">
<script type="text/javascript" src="js/login.js"></script>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=85af9840b8713b35481bb6ab8c998933&libraries=services"></script>
</head>
</head>
<body>

	<div class="toolbar">
		<div class="toolbar-info">
			<div
				style="display: flex; width: 80%; justify-content: space-evenly; font-size: 15pt; align-items: center;">
				<div>
					<a style="text-decoration: none; color: white;" href="tourC">관광지</a>
				</div>
				<div>
					<a style="text-decoration: none; color: white;"
						href="roomAllsearchC">숙소</a>
				</div>
				<div>
					<a style="text-decoration: none; color: white;" href="GourmetC">식당</a>
				</div>
				<div>
					<a style="text-decoration: none; color: white;" href="RentShopC">렌터카</a>
				</div>
				<div>
					<a style="text-decoration: none; color: white;" href="JsnHC">전통주</a>
				</div>
			</div>
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
	<h2>구루메 인덱스 페이지</h2>
	<form action="GourmetSearchC" method="post">
		<select name="select">
			<option value="name">상호</option>
			<option value="location">위치</option>
		</select> <input name="input"></input>
		<button>search</button>


	</form>
	<hr>
	<div style="display: flex;">
		<div><jsp:include page="${contentPage }"></jsp:include></div>
	</div>


</body>
</html>