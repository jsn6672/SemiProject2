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
				<li><a href="ProposalHC">All</a></li>
				<li><a href="ProposalTypeC?type=travel">Travel</a></li>
				<li><a href="ProposalTypeC?type=stay">Stay</a></li>
				<li><a href="ProposalTypeC?type=food">Food</a></li>
				<li><a href="ProposalTypeC?type=rentcar">RentCar</a></li>
				<li><a href="ProposalTypeC?type=liquor">Liquor</a></li>
			</ul>
		</div>
		<div class="asking_body">
			<br>
			<div>
				<div class="asking_body_header">
					&nbsp;&nbsp;
					<div class="asking_form">제목</div>
					&nbsp;&nbsp;
					<div class="asking_writer">&nbsp;&nbsp;글쓴이</div>
					<div class="asking_time">시간</div>
					<div>추천</div>
				</div>
				<br> <br>
				<div>
					<jsp:include page="${listPage }"></jsp:include>
				</div>
			</div>
			<br> <br>
			<form action="RegProposalC">
				<div class="asking_comment">
					<a>ID</a> <select name="type">
						<option value="travel">여행</option>
						<option value="stay">숙박</option>
						<option value="food">음식점</option>
						<option value="rentcar">렌터카</option>
						<option value="liquor">전통주</option>
					</select>
					<textarea class="asking_comment_form" name="content"></textarea>
					<button class="comment_confirm">등록</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>