<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
    String userid = request.getParameter("userId");

    if (userid.equals("userid")) {
        out.print("0");
    } else {
        out.print("1");
    }
%>
</body>
</html>