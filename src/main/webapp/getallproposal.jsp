<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Proposal.css">
</head>
<body>
	<c:forEach items="${proposal }" var="r">
		<div class="asking_body_header2" onclick="location.href='SeeProposalC'">
			<div class="asking_body_form">[${r.t_type }]${r.t_title }</div>
			<div class="asking_body_writer">${r.t_user }</div>
			<div class="asking_body_time">${r.t_date }</div>
			<div class="asking_body_thumbsup">${r.t_grade}&nbsp;&nbsp;<button>like</button></div>
		</div>
	</c:forEach>
</body>
</html>