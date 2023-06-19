<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f6d7d797f4c680fd25e3195c23d98ca&libraries=services"></script>
</head>

<body>

	<form action="roomSearchC">
		<input name="hotelsearch" type="text">
		<button>검색</button>
	</form>

	<br>

	<div class="container_hm">
		<div class="hotel_list">
			<input type="hidden" name="page">

			<c:choose>
				<c:when test="${empty hotels}">
					<span>검색결과가 없습니다.</span>
				</c:when>
				<c:otherwise>

					<c:forEach items="${hotels }" var="h">
						<div class="hotel_content">

							<div class="hotel_img">
								<img alt="" src="${h.r_imgpath }">
							</div>

							<div class="hotel_info">
								<div class="room_title">${h.r_title }</div>
								<div class="hotel_roadaddress">
									<p>주소 : ${h.r_roadaddress }</p>
								</div>
								<button name="clickhotel"
									onclick="location.href='roomClickC?place=${h.r_roadaddress }'">위치
									찾기</button>
							</div>
						</div>
						<br>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			${curPageNo }
			<div class="paging">
				<a href="roomPageC?p=1>">[◀◀]</a>
				<c:forEach begin="1" end="${pageCount }" var="i">
					<a href="roomPageC?p=${i }">[${i }]</a>
				</c:forEach>
				<a href="roomPageC?p=${pageCount }">[▶▶]</a>
			</div>
		</div>

		<hr>

		<div class="right_side">
			<input type="hidden" id="place" value="${param.place }">
			<div id="hm_map"></div>

			<div class="reviewbox">
				<div style="text-align: center; border: 1px solid #dddddd">
					<div style="background-color: #eeeeee; text-align: center;">
						글쓰기 양식</div>
					<div class="review_title">
						<input type="text" class="form-control" placeholder="글 제목"
							name="bbsTitle" maxlength="50">
					</div>
					<div class="review_text">
						<textarea class="form-control" placeholder="글 내용"
							name="bbsContent" maxlength="2048" style="height: 350px;"></textarea>
					</div>
				</div>
				<div>
					<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
				</div>
			</div>


		</div>


	</div>

	<script type="text/javascript" src="js/mapmarking.js">
		
	</script>

</body>
</html>