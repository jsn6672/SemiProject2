<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/asking.css">
</head>
<body>
	<div class="asking_header">
		<h1>건의 게시판</h1>
		<select id="asking_selectbox">
			<option>최신순</option>
			<option>업데이트순</option>
			<option>추천순</option>
		</select>
	</div>

	<hr id="asking_header_hr">
<div class="container">
	<div class="ask_Nav">
	<br>
		<ul class="navigation">
			<li id="navigation_li"><a href="#">전체보기</a></li>
			<li><a href="#">여행</a></li>
			<li><a href="#">숙소</a></li>
			<li><a href="#">음식</a></li>
			<li><a href="#">렌트카</a></li>
			<li><a href="#">전통술</a></li>
		</ul>
		<br>
		<br>
	</div>
	<div class="asking_body">
	<br>
	<div> 
		<div class="asking_body_header"><div class="asking_form">내용</div>&nbsp;&nbsp;<div class="asking_writer">글쓴이</div><div class="asking_time">시간</div><div>추천</div></div>
		<br>
		<br>
		<div class="asking_body_all"><div class="asking_form">내용</div>&nbsp;&nbsp;<div class="asking_writer">글쓴이</div><div class="asking_time">시간</div><a href="#">like</a></div>
		<div class="asking_body_all"><div class="asking_form">내용</div>&nbsp;&nbsp;<div class="asking_writer">글쓴이</div><div class="asking_time">시간</div><a href="#">like</a></div>
		<div class="asking_body_all"><div class="asking_form">내용</div>&nbsp;&nbsp;<div class="asking_writer">글쓴이</div><div class="asking_time">시간</div><a href="#">like</a></div>
		<div class="asking_body_all"><div class="asking_form">내용</div>&nbsp;&nbsp;<div class="asking_writer">글쓴이</div><div class="asking_time">시간</div><a href="#">like</a></div>
		<div class="asking_body_all"><div class="asking_form">내용</div>&nbsp;&nbsp;<div class="asking_writer">글쓴이</div><div class="asking_time">시간</div><a href="#">like</a></div>
	</div>
	<br>
	<br>
	<div class="asking_comment">
		<a>ID</a>
		<textarea class="asking_comment_form"></textarea>
		<button class="comment_confirm">등록</button>
	</div>
		
	</div>
</div>
</body>
</html>