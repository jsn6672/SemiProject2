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
	<form action="roomSearchC">
		<input name="hotelsearch" type="text">
		<button>검색</button>
	</form>

	<br>
	<div class="container_hm" >
			<c:forEach items="${hotels }" var="h">
				<div class="hotel_list">
					<div class="hotel_img">
						<img alt="" src="${h.r_imgpath }">
					</div>
					<div class="hotel_info">
						<div class="room_title">${h.r_title }</div>
						<div>
							<p>${h.r_roadaddress }</p>
						</div>
						<div>
							<button>자세히 보기</button>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
</body>
</html>