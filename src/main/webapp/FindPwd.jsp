<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/pwd_changer.css">
<script type="text/javascript" src="js/FindPwd.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="pwd_Changer_Popup" id="Pwd_Changer_Popup">
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
					<div class="item1-change">PW confirm</div>
					<div class="item2-change">
						<input id="newPwdCheck" type="password" name="newPwdCheck"
							placeholder="비밀번호 재확인" class="textInput-reg" autocomplete="off">
						<div id="pwCheckError" class="error"></div>
					</div>
				</div>
				<div class="btn-area">
						<button class="loginConfirm_btn" id="Confirm_btn" type="submit">Confirm</button>
					</div>
	</div>
</body>
</html>