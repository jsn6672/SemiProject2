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
						<input name="name" placeholder="�ʼ�" class="textInput-reg"
							autocomplete="off" required>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">ID</div>
					<div class="item2-reg">
						<input name="id" placeholder="��,���� ���� 5���� �̻�"
							class="textInput-reg" autocomplete="off" required>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">PW</div>
					<div class="item2-reg">
						<input type="password" name="pw" placeholder="��,����,Ư�� ���� 8���� �̻�"
							class="textInput-reg" autocomplete="off" required>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">PW confirm</div>
					<div class="item2-reg">
						<input type="password" name="pw" placeholder="��й�ȣ ��Ȯ��"
							class="textInput-reg" autocomplete="off" required>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">Gender</div>
					<div class="item2-reg gender">
						<label><input type="radio" name="gender" value="��"
							checked="checked"> ����</label> <label><input type="radio"
							name="gender" value="��"> ����</label>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">Address</div>
					<div class="item2-reg">
						<select name="addr">
							<option value="seoul">����</option>
							<option value="deajeon">����</option>
							<option value="deagu">�뱸</option>
							<option value="busan">�λ�</option>
							<option value="gwangju">����</option>
							<option value="ulsan">���</option>
							<option value="incheon">��õ</option>
							<option value="kyeonggi">��⵵</option>
							<option value="gangwon">������</option>
							<option value="Nchungcheong">��û�ϵ�</option>
							<option value="Schungcheong">��û����</option>
							<option value="Njeonla">����ϵ�</option>
							<option value="Sjeonla">���󳲵�</option>
							<option value="Ngyeongsang">���ϵ�</option>
							<option value="Sgyeongsang">��󳲵�</option>
							<option value="jeju">���ֵ�</option>
							<option value="foreign">�ؿܰ���</option>
						</select>
					</div>
				</div>
				<div class="items-reg">
					<div class="item1-reg">Question</div>
					<div class="item2-reg">
						<select name="question">
							<option value="QnA1">����� ���� �����ϴ� ������?</option>
							<option value="QnA2">����� ���� 1ȣ��?</option>
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