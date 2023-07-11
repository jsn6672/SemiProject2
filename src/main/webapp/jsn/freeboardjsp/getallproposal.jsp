<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="jsn/css/Proposal.css">
</head>
<body>
	<c:forEach items="${proposal }" var="r">
		<div class="asking_body_header2">
			<div class="asking_body_form" style="overflow: auto;">[${r.t_type }]${r.t_content }</div>
			<div class="asking_body_writer">${r.t_user }</div>
			<div class="asking_body_time">${r.t_date }</div>
			<div class="asking_body_thumbsup">${r.t_grade}&nbsp;&nbsp;<button onclick="location.href ='ProposalGradeC?no=${r.t_no}&grade=${r.t_grade}'">like</button>
			</div>
		</div>
	</c:forEach>
	<div>
		<a href="ProposalPagingC?pageno=1">[처음]</a>
		<c:forEach begin="1" end="${PageCount }" var="i">
			<a href="ProposalPagingC?pageno=${i }">
				[${i }] </a>
		</c:forEach>
		<a
			href="ProposalPagingC?pageno=${PageCount }">[끝]</a>
	</div>
</body>
</html>