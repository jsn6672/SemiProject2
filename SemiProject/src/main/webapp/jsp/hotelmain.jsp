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
	<form action="roomSearchC" >
	<input name="hotelsearch" type="text"> 
	<button> 검색</button>
	</form>
	
	<c:forEach items="${hotels }" var="h">
		<div class="room_title"> ${h.r_title }</div>
		<div> <button> 자세히 보기</button> </div>
	</c:forEach>

</body>
</html>