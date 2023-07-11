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

	<div class="drink-detail-all">
		<div class="drink-detail-info">
			<div>
				<img class="drink-detail-img" alt="" src="${drink_detail.t_img }">
			</div>
			<div class="drink-detail-body">
				<div class="drink-detail-detail">
					<div class="td1">名</div>
					<hr class="hr_line">
					&nbsp;&nbsp;&nbsp;
					<div class="td2">${drink_detail.t_name }</div>
				</div>
				<div class="drink-detail-detail">
					<div class="td1">度数</div>
					<hr class="hr_line">
					&nbsp;&nbsp;&nbsp;
					<div class="td2">${drink_detail.t_level }%</div>
				</div>
				<div class="drink-detail-detail">
					<div class="td1">容量</div>
					<hr class="hr_line">
					&nbsp;&nbsp;&nbsp;
					<div class="td2">${drink_detail.t_volume }ml</div>
				</div>
				<div class="drink-detail-detail">
					<div class="td1">評点</div>
					<hr class="hr_line">
					&nbsp;&nbsp;&nbsp;
					<div class="td2">${drink_detail.t_avgscore/2 }</div>
				</div>
				<div class="drink-detail-detail">
					<div class="td1">主原料</div>
					<hr class="hr_line">
					&nbsp;&nbsp;&nbsp;
					<div class="td2">${drink_detail.t_material }</div>
				</div>
				<div class="drink-detail-detail">
					<div class="td1">醸造場</div>
					<hr class="hr_line">
					&nbsp;&nbsp;&nbsp;
					<div class="td2">${brewer.b_name }</div>
				</div>
				<div class="drink-detail-detail">
					<div class="td1">醸造所の住所</div>
					<hr class="hr_line">
					&nbsp;&nbsp;&nbsp;
					<div class="td2">${brewer.b_addr }</div>
				</div>
			</div>
		</div>
		<div id="map" class="drink-map"></div>
	</div>

	<div class="review_details">
		<c:if test="${not empty review}">
			<div>
				<c:forEach items="${review }" var="r">
					<div class="review_content">
						<div class="jsn-user-name">${r.r_user }</div>
						<hr>
						<div class="jsn-starpoint">
							<span class="drink-starpoint">★</span>${r.r_starpoint/2 }</div>
						<hr>
						<div class="jsn-review-content">${r.r_review}</div>
						<div>
							<img src="jsn/imgfile/${r.r_img }" class="jsnReviewimg"
								width="100px" onclick="fnImgPop(this.src)">
						</div>
					</div>
				</c:forEach>
				<div class="drink-review-page">
					<a
						href="DrinkSearchReviewC?p=1&no=${drink_detail.t_no }&listp=${curListPageNo}">[맨처음]</a>
					<c:forEach begin="1" end="${reviewPageCount }" var="i">
						<a
							href="DrinkSearchReviewC?p=${i }&no=${drink_detail.t_no }&listp=${curListPageNo}">
							[${i }] </a>
					</c:forEach>
					<a
						href="DrinkSearchReviewC?p=${reviewPageCount }&no=${drink_detail.t_no }&listp=${curListPageNo}">[맨
						끝]</a>
				</div>
			</div>
		</c:if>
		<form action="DrinkSearchReviewC" method="post"
			enctype="multipart/form-data">
			<div class="review_items" style="display: flex;">
				<div class="jsn-user-name">
					<input name="language" value="2" hidden="hidden">
				</div>
				<div class="jsn-review-starpoint">
					<span class="star"> ★★★★★ <span>★★★★★</span> <input
						name="starpoint" type="range" oninput="drawStar(this)" value="1"
						step="1" min="0" max="10">
					</span>
				</div>
				<div class="drinkreview-create">
					<textarea class="review_txtbox" rows="3" cols="80" name="review"
						placeholder="리뷰를 입력 하세요."></textarea>
				</div>
				<div class="drinkreview-button">
					<input name="listp" value="${curListPageNo}" hidden=""> <input
						type="file" name="review_img">
					<button name="no" value="${drink_detail.t_no }">등록</button>
				</div>
			</div>
		</form>
	</div>


</body>
<script type="text/javascript">
	function fnImgPop(url) {
		var img = new Image();
		img.src = url;
		var img_width = img.width;
		var win_width = img.width + 25;
		var img_height = img.height;
		var win = img.height + 30;
		var OpenWindow = window.open('', '_blank', 'width=' + img_width
				+ ', height=' + img_height + ', menubars=no, scrollbars=auto');
		OpenWindow.document
				.write("<style>body{margin:0px;}</style><img src='"+url+"' width='"+win_width+"'>");
	}
</script>
</html>