<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/toolbar.css">
<link rel="stylesheet" type="text/css" href="css/widget.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/quick_menu.css">
<script type="text/javascript" src="js/login.js"></script>
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
	<h1>건의게시판</h1>
	<div>
		<jsp:include page="${contentPage }"></jsp:include>

	</div>



</body>
</html>