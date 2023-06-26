<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="jsn-content">
		<c:forEach items="${drink }" var="i">
			<div class="jsn-list" style="display: flex;">
				<div style="border: 1px solid black;">
					<a href="DrinkDetailC?no=${i.t_no }&language=2">${i.t_name }</a>
				</div>
				<div style="border: 1px solid black;">${i.t_market }</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>