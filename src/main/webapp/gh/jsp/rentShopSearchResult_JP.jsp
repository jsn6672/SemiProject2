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
<input name="gh_lang" value="jp" hidden="">
<%-- pageNum=${pageNum }&search=${search }&lat=${r.latitude }&lng=${r.longitude}&placeName=${r.placeName}--%>
	
	<c:forEach items="${rentShops}" var="r">
		<div class="rentShopList">
			<div class="rentShopList_item">
				<div><a href="RentShopDetailC?no=${r.placeNo }&listp=${curPageNo}">場所名: ${r.placeName }</a></div>
				<div>道路名住所: ${r.addressDoro }</div>
				<div>地番住所: ${r.addressJibun }</div>
				<div>レビュー平均: ${r.gradeAvg }</div>
				<div>レビュー数: ${r.gradeCnt }</div>
			</div>
		</div>
	</c:forEach>

	<div class="pageInfo">
		<a class="list-page-a" value="1"> [1ページ] </a>
		<c:forEach begin="1" end="${totalPage }" var="i">
			<a class="list-page-a" value="${i}">[${i }]</a>
		</c:forEach>
		<a class="list-page-a"  value="${totalPage }"> [最後のページ] </a>
	</div>

</body>



</html>