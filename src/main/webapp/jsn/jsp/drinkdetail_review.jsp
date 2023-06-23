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

	<div style="display: flex;">
		<div class="drink-detail-info" style="font-size: 15pt; width: 60%;">
			<div style="display: flex;">
				<div class="td1">이름</div>
				<div class="td2">${drink_detail.t_name }</div>
			</div>
			<div style="display: flex;">
				<div class="td1">평점</div>
				<div class="td2">${drink_detail.t_avgscore/2 }</div>
			</div>
			<div style="display: flex;">
				<div class="td1">도수</div>
				<div class="td2">${drink_detail.t_level }%</div>
			</div>
			<div style="display: flex;">
				<div class="td1">용량</div>
				<div class="td2">${drink_detail.t_volume }ml</div>
			</div>
			<div style="display: flex;">
				<div class="td1">주 원료</div>
				<div class="td2">${drink_detail.t_material }</div>
			</div>
			<div style="display: flex;">
				<div class="td1">양조장</div>
				<div class="td2">${brewer.b_name }</div>
			</div>
			<div style="display: flex;">
				<div class="td1">양조장 주소</div>
				<div class="td2">${brewer.b_addr }</div>
			</div>
		</div>
		<img alt="" width="200px;" src="${drink_detail.t_img }">
		<div id="map" style="width: 20%; height: 350px;"></div>
	</div>

	<div>
		<c:if test="${not empty review}">
			<div>
				<c:forEach items="${review }" var="r">
					<div style="display: flex;">
						<div class="jsn-user-name">${r.r_user }</div>
						<div class="jsn-starpoint">
							<span style="color: orange;">★</span>${r.r_starpoint/2 }</div>
						<div class="jsn-review-content">${r.r_review}</div>
						<div>
							<img src="jsn/imgfile/${r.r_img }" height="100px">
						</div>
					</div>
				</c:forEach>
				<div>
					<a
						href="DrinkReviewC?p=1&no=${drink_detail.t_no }&listp=${curListPageNo}">[맨처음]</a>
					<c:forEach begin="1" end="${reviewPageCount }" var="i">
						<a
							href="DrinkReviewC?p=${i }&no=${drink_detail.t_no }&listp=${curListPageNo}">
							[${i }] </a>
					</c:forEach>
					<a
						href="DrinkReviewC?p=${reviewPageCount }&no=${drink_detail.t_no }&listp=${curListPageNo}">[맨
						끝]</a>
				</div>
			</div>
		</c:if>
		<form action="DrinkReviewC" method="post"
			enctype="multipart/form-data">
			<div style="display: flex;">
				<div class="jsn-user-name">
					리뷰 입력 <input name="language" value="2" hidden="hidden">
				</div>
				<div>
					<span class="star"> ★★★★★ <span>★★★★★</span> <input
						name="starpoint" type="range" oninput="drawStar(this)" value="1"
						step="1" min="0" max="10">
					</span>
				</div>
				<div class="review-create">
					<textarea rows="3" cols="80" name="review"></textarea>
				</div>
				<div class="review-button">
					<input name="listp" value="${curListPageNo}" hidden=""> <input
						type="file" name="review_img">
					<button name="no" value="${drink_detail.t_no }">등록</button>
				</div>
			</div>
		</form>
	</div>


</body>
</html>