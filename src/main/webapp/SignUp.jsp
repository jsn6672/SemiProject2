<%-- JSP 코드 --%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup.css">
<script type="text/javascript" src="js/signUpCheck.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-reg">
		<div class="signup-window">
			<form action="SignUpC" method="post" onsubmit="return signUpCheck();">
				<h1>Sign Up</h1>
				<div class="items-reg">
					<div class="item1-reg">ID</div>
					<div class="item2-reg">
						<input id="id" name="userId" placeholder="영,숫자 포함 5글자 이상"
							class="textInput-reg" autocomplete="off">
							<div id="idError" class="error"></div>
						<br><button onclick="idCheck() return false" class="idck" id="idck">중복확인</button>
						<div id="idCheckResult"></div>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">PW</div>
					<div class="item2-reg">
						<input id="pw" type="password" name="userPw"
							placeholder="영,숫자,특문 포함 8글자 이상" class="textInput-reg"
							autocomplete="off">
						<div id="pwError" class="error"></div>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">PW confirm</div>
					<div class="item2-reg">
						<input id="pwCheck" type="password" name="userPwCheck"
							placeholder="비밀번호 재확인" class="textInput-reg" autocomplete="off">
						<div id="pwCheckError" class="error"></div>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">Name</div>
					<div class="item2-reg">
						<input id="name" name="userName" placeholder="본명 or 닉네임"
							class="textInput-reg" autocomplete="off">
						<div id="nameError" class="error"></div>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">Gender</div>
					<div class="item2-reg-gender">
						<label><input class="gender" type="radio" name="gender"
							value="남" checked="checked"> 남자</label><label><input
							type="radio" name="gender" value="여"> 여자</label>
					</div>
					<div class="items-reg">
						<div class="item1-reg">Birth</div>
						<div class="item2-reg">
							<input name="userBirth" placeholder="YY-MM-DD"
								class="textInput-reg" autocomplete="off">
							<div id="birthError" class="error"></div>
						</div>
					</div>
				</div>
				<div class="items-reg-question">
					<div class="item1-reg-question">Question</div>
					<br>
					<div class="item2-reg" id="question">
						<select id="question_selectbox" name="question">
							<option value="1">당신이 가장 좋아하는 색깔은?</option>
							<option value="2">당신의 보물 1호는?</option>
						</select>
						<div class="answer">
							<input class="textInput-reg" type="text" name="userAnswer"
								id="answer" autocomplete="off" placeholder="질문에 대한 답변">
							<div id="answerError" class="error"></div>
						</div>
					</div>
				</div>
				<br>
				<div class="signUp_btns">
					<button class="signup_btn" onclick="location.href='SignUpC'">Sign Up</button>
				<button onclick="window.location.href='index.jsp'"class="signupCancel_btn" type="button">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</body>

</html>