<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/hm.css">

</head>
<body>

	<table style="display: flex">
		<tr>
			<td><a href="roomAllsearchC">숙박</a></td>
		</tr>
		<tr>
			<td>
			<form action="roomAllsearchC" method="get">
			<select class="languageselect" name="langauage"> 
			 <option value="kr"> korean </option>
			 <option value="jp"> japan </option>
			</select>
			<button> 변경 </button>
			</form>
			</td>
		</tr>
	</table>

	<table id="site">
		<tr>
			<td><jsp:include page="${contentPage }"></jsp:include></td>
		</tr>
	</table>

</body>
</html>
