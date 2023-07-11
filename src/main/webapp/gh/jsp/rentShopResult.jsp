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
<input name="gh_lang" value="kr" hidden="">
<%-- pageNum=${pageNum }&search=${search }&lat=${r.latitude }&lng=${r.longitude}&placeName=${r.placeName}--%>
	
	<c:forEach items="${rentShops}" var="r">
		<div class="rentShopList">
			<div class="rentShopList_item">
				<div><a href="RentShopDetailC?no=${r.placeNo }&listp=${curPageNo}">장소명: ${r.placeName }</a></div>
				<div>도로명 주소: ${r.addressDoro }</div>
				<div>지번 주소: ${r.addressJibun }</div>
				<div>평점 평균: ${r.gradeAvg }</div>
				<div>리뷰 수: ${r.gradeCnt }</div>
			</div>
		</div>
	</c:forEach>

	<div class="pageInfo">
		<a class="list-page-a" value="1"> [맨 앞] </a>
		<c:forEach begin="1" end="${totalPage }" var="i">
			<a class="list-page-a" value="${i}">[${i }]</a>
		</c:forEach>
		<a class="list-page-a"  value="${totalPage }"> [맨 끝] </a>
	</div>

</body>



</html>