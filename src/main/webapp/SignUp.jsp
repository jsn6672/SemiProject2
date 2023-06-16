<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup.css">
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="container-reg">
		<form action="SignUpC" method="post" enctype="multipart/form-data">
			<div class="signup-window">
				<h1>Sign Up</h1>
				<br>
				<div class="items-reg">
					<div class="item1-reg">Name</div>
					<div class="item2-reg">
						<input name="name" placeholder="필수" class="textInput-reg"
							autocomplete="off" required>
					</div>
				</div>
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
					<div class="item1-reg">Gender</div>
					<div class="item2-reg gender">
						<label><input type="radio" name="gender" value="남"
							checked="checked"> 남자</label> <label><input type="radio"
							name="gender" value="여"> 여자</label>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">Address</div>
					<div class="item2-reg">
						<select name="addr">
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
				<div class="items-reg">
					<div class="item1-reg">Question</div>
					<div class="item2-reg">
						<select name="question">
							<option value="QnA1">당신이 가장 좋아하는 색깔은?</option>
							<option value="QnA2">당신의 보물 1호는?</option>
						</select>
						<input type="text" name="answer" id="answer" autocomplete="off" required>
					</div>
				</div>
				<div class="items-reg item3-reg">
					<div class="button-reg">
						<br>
						<button class="signup_btn" type="submit">Sign up</button>
						<br>
						<button class="signupCancel_btn" type="submit">Cancel</button>
					</div>
				</div>
			</div>
	</div>
	</form>
</body>
</html>