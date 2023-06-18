<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup.css">
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<div class="container-reg">
			<div class="signup-window">
	<form action="SignUpC" method="post" enctype="multipart/form-data">
				<h1>Sign Up</h1>
				<div class="items-reg">
					<div class="item1-reg">ID</div>
					<div class="item2-reg">
						<input name="id" placeholder="영,숫자 포함 5글자 이상"
							class="textInput-reg" autocomplete="off" required>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">PW</div>
					<div class="item2-reg">
						<input type="password" name="pw" placeholder="영,숫자,특문 포함 8글자 이상"
							class="textInput-reg" autocomplete="off" required>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">PW confirm</div>
					<div class="item2-reg">
						<input type="password" name="pw" placeholder="비밀번호 재확인"
							class="textInput-reg" autocomplete="off" required>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">Name</div>
					<div class="item2-reg">
						<input name="name" placeholder="본명 or 닉네임" class="textInput-reg"
							autocomplete="off" required>
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
						<div class="item2-reg-birth birth_box">
							<select name="year">
								<option value="1900">1900</option>
								<option value="1901">1901</option>
								<option value="1902">1902</option>
							</select><a>년</a> <select name="month">
								<option value="12">12</option>
								<option value="11">11</option>
								<option value="10">10</option>
								<option value="09">09</option>
								<option value="08">08</option>
								<option value="07">07</option>
								<option value="06">06</option>
								<option value="05">05</option>
								<option value="04">04</option>
								<option value="03">03</option>
								<option value="02">02</option>
								<option value="01">01</option>
							</select><a>월</a> <select name="day">
								<option value="31">31</option>
								<option value="30">30</option>
								<option value="29">29</option>
								<option value="28">28</option>
							</select><a>일</a>
						</div>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">Address</div>
					<div class="item2-reg-addr addr_box">
						<select name="address">
							<option value="seoul">서울</option>
							<option value="deajeon">대전</option>
							<option value="deagu">대구</option>
							<option value="busan">부산</option>
							<option value="gwangju">광주</option>
							<option value="ulsan">울산</option>
							<option value="incheon">인천</option>
							<option value="kyeonggi">경기도</option>
							<option value="gangwon">강원도</option>
							<option value="Nchungcheong">충청북도</option>
							<option value="Schungcheong">충청남도</option>
							<option value="Njeonla">전라북도</option>
							<option value="Sjeonla">전라남도</option>
							<option value="Ngyeongsang">경상북도</option>
							<option value="Sgyeongsang">경상남도</option>
							<option value="jeju">제주도</option>
							<option value="foreign">해외거주</option>
						</select>
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
								id="answer" autocomplete="off" placeholder="질문에 대한 답변" required>
						</div>
					</div>
				</div>
				<div class="items-reg">
					<button class="signup_btn" type="submit">Sign up</button>
				</div>
	</form>
	<form action="Main_HC">
		<button class="signupCancel_btn" type="submit">Cancel</button>
	</form>
	</div>
	</div>
</body>
</html>