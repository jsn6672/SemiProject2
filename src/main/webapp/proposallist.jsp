<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Proposal.css">
</head>
<body>

<hr class="header_hr">
<div class="container">
	<div class="toolbar-info">
			<ul class="toolbar_nav2">
				<li><a href="Pro">All</a></li>
				<li><a href="ProposalTourC">Travel</a></li>
				<li><a href="ProposalRoomC">Stay</a></li>
				<li><a href="ProposalGourmetC">Food</a></li>
				<li><a href="ProposalRenterC">RentCar</a></li>
				<li><a href="ProposalDrinkC">Liquor</a></li>
			</ul>
	</div>
	<div class="asking_body">
	<br>
	<div> 
		<div class="asking_body_header">&nbsp;&nbsp;<div class="asking_form">제목</div>&nbsp;&nbsp;<div class="asking_writer">&nbsp;&nbsp;글쓴이</div><div class="asking_time">시간</div><div>추천</div></div>
		<br>
		<br>
		<div>
			<jsp:include page="${listPage }"></jsp:include>
		</div>
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