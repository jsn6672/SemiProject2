<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/hm.css">
<link rel="stylesheet" href="css/review.css">


</head>
<body>

	<table>
		<tr>
			<td> <a href="roomAllsearchC">숙박</a> </td>
		</tr>
	</table>

	<table id="site">
		<tr>
			<td><jsp:include page="${contentPage }"></jsp:include></td>
		</tr>
	</table>

</body>
</html>	