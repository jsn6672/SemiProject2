<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup.css">
<script type="text/javascript" src="js/signUpCheck.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"
	integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
	crossorigin="anonymous">
	
</script>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-reg">
		<div class="signup-window">
			<form action="" method="post" onsubmit="return signUpCheck()">
				<h1>Sign Up</h1>
				<div class="items-reg">
					<div class="item1-reg">ID</div>
					<div class="item2-reg">
						<input id="id" name="id3"
							placeholder="영,숫자 포함 5글자 이상" class="textInput-reg"
							autocomplete="off">
						<div id="idError" class="error"></div>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">PW</div>
					<div class="item2-reg">
						<input id="pw" type="password" name="pw"
							placeholder="영,숫자,특문 포함 8글자 이상" class="textInput-reg"
							autocomplete="off">
						<div id="pwError" class="error"></div>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">PW confirm</div>
					<div class="item2-reg">
						<input id="pwCheck" type="password" name="pwCheck"
							placeholder="비밀번호 재확인" class="textInput-reg" autocomplete="off">
						<div id="pwCheckError" class="error"></div>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">Name</div>
					<div class="item2-reg">
						<input id="name" name="name" placeholder="본명 or 닉네임"
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
							<input name="birth" placeholder="YY-MM-DD" class="textInput-reg"
								autocomplete="off">
						</div>
					</div>
				</div>
				<div class="items-reg-question">
					<div class="item1-reg-question">Question</div>
					<br>
					<div class="item2-reg" id="question">
						<select id="question_selectbox" name="question">
							<option value="QnA1">당신이 가장 좋아하는 색깔은?</option>
							<option value="QnA2">당신의 보물 1호는?</option>
						</select>
						<div class="answer">
							<input class="textInput-reg" type="text" name="answer"
								id="answer" autocomplete="off" placeholder="질문에 대한 답변">
						</div>
					</div>
				</div>
				<br>
				<div class="items-reg">
					<button class="signup_btn">Sign Up</button>
				</div>
			</form>
			<form action="Main_HC">
				<button class="signupCancel_btn" type="button">Cancel</button>
			</form>
		</div>
	</div>
</body>

</html>