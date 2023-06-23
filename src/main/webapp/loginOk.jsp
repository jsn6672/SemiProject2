<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<a style = "color:white; padding-top:1%;">${account.name }님 환영합니다.</a><br>
	<a href="#quick" class="quick_btn">quick</a>
	<form action="loginC">
	<a href="loginC"class="logout_btn">Logout</a>
</form>
</body>
</html>