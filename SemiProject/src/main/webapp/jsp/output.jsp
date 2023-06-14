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
	<script src="https://code.jquery.com/jquery-3.7.0.js"
		integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
		crossorigin="anonymous"></script>
	<script>
		$.ajax({
			method : "GET",
			url : "//dapi.kakao.com/v2/maps/sdk.js",
			data : {
				apiKey : "fd13562c5c57bec30eea349fa602ff9b",
				
			}

		}).done(function(msg) {
			console.log(msg);
		});
	</script>


	<table>
		<tr>
			<td><input type="text"> <button>검색</button></td>
		</tr>
	</table>

</body>
</html>