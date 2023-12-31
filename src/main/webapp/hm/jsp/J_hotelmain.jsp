<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/overlaycustom.css">
<link rel="stylesheet" href="css/review.css">
<title>Insert title here</title>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f6d7d797f4c680fd25e3195c23d98ca&libraries=services"></script>
</head>

<body>
	<div class="container_hm">
		<input type="hidden" name="page">

		<div class="left-side">
			<div class="hotel_search">
				<form action="roomSearchC">
					<input name="hotelsearch" type="text">
					<button>검색</button>
				</form>
			</div>
			<div class="hotel_list">
				<!-- 
	  	 <div>
		<form action="ACDcontroller">
			<button>데이터 전환</button>
		</form>
	</div>
	 <div>
		<form action="ACDcontroller2">
			<button>데이터 전환</button>
		</form>
	</div>-->
				<br>
				<c:choose>
					<c:when test="${empty hotels }">
						<span>検索結果がありません</span>
					</c:when>
					<c:otherwise>

						<c:forEach items="${hotels }" var="h">
							<div class="hotel_content" data-roadaddress="${h.r_roadaddress}"
								data-title="${h.r_title}"
								data-introduction="${h.r_introduction}"
								data-imgpath="${h.r_imgpath}" data-tag="${h.r_tag}"
								onclick="moveToLocationByAddress(this.dataset.roadaddress, this.dataset.title, this.dataset.introduction, this.dataset.imgpath, this.dataset.tag)">
								<div class="hotel_img">
									<img src="${h.r_imgpath }" alt="…">
								</div>
								<div class="hotel_info">
									<div class="hotel_title">${h.r_title }</div>
									<div class="hotel_information">
										<p>連絡所 : ${h.r_phoneno }</p>
										<p>住所 : ${h.r_address }</p>
									</div>
									<input type="hidden" name="hm_cid" value="${h.r_cid }">
									<input type="hidden" name="hm_title" value="${h.r_title }">
								</div>
								<div class="button_list">
									<button
										onclick="hmOpenReviewWrite('${h.r_cid }', '${h.r_title }')">レビュー作成</button>
								<button name="titleSearch" onclick="callReviewList('${h.r_title }')">レビューを見る</button>
									<!-- 								<form action="reviewlistC"> -->
									<!-- 									<div class="rv"> -->
									<%-- 										<button name="titleSearch" value="${h.r_title }">리뷰 --%>
									<!-- 											보기</button> -->
									<!-- 									</div> -->
									<!-- 								</form> -->
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
		</div>
		<hr>

		<div class="right_side">
			<input type="hidden" id="place" value="${param.place }">
			<div id="hm_map"></div>

			<div class="review_list">
				<table class="column">
				<c:choose>
					<c:when test="${empty reviews }">
						<span class="center">検索結果がありません</span>
					</c:when>
					<c:otherwise>
				
				
				
					<c:forEach items="${reviews }" var="get">
						<tbody>
							<tr class="head">
								<td class="imgfile"><img alt="" src="${get.r_img }"></td>
								<td>${get.r_reviewname }</td>
							</tr>
							<tr class="body">
								<td>${get.r_text }</td>
							</tr>
							<tr>
								<td>${get.r_title }</td>
								<td>${get.r_date }</td>
							</tr>
						</tbody>
						<tr>
							<td>
								<form action="reviewDeleteC" method="get"
									onsubmit="return confirmDelete();">
									<input type="hidden" name="cid" value="${get.r_cid }">
									<input type="hidden" name="no" value="${get.r_no }">
									<button type="submit" name="deleteReview" value="${get.r_no }">삭제</button>
								</form>
							</td>
						</tr>
					</c:forEach>
					</c:otherwise>
				</c:choose>
				</table>
			</div>
		</div>
	</div>

	<!-- 리뷰 작성 모달 창 -->
	<div id="hmReviewWrite" class="hm-review-write">
		<div class="hm-review-content-write">
			<span onclick="hmCloseReviewWrite()" class="hm-close">&times;</span>
			<h2>レビューを作成してください</h2>
			<form action="reviewRegC" method="post" enctype="multipart/form-data">
				<div>
					<div>
						<input hidden="cid2" name="hm_r_cid"> <input
							hidden="title2" name="hm_r_title">
						<div class="rating">
							<span class="star" data-value="1">☆</span> <span class="star"
								data-value="2">☆</span> <span class="star" data-value="3">☆</span>
							<span class="star" data-value="4">☆</span> <span class="star"
								data-value="5">☆</span> <input type="hidden" name="r_starpoint"
								id="starpoint">
						</div>
						<!-- 							<div> -->
						<!-- 								평점 <select id="hm-reviewGrade" name="hm_reviewGrade"> -->
						<!-- 									<option value="1">★</option> -->
						<!-- 									<option value="2">★★</option> -->
						<!-- 									<option value="3">★★★</option> -->
						<!-- 									<option value="4">★★★★</option> -->
						<!-- 									<option value="5">★★★★★</option> -->
						<!-- 								</select> -->
						<!-- 							</div> -->
					</div>
					<div>
						<div>
							<input placeholder="題目" name="hm_r_reviewname">
						</div>
						<div>
							<textarea name="hm_r_text" rows="10" cols="70"></textarea>
						</div>
					</div>

					<div>
						<div>
							사진 <input name="hm_r_pic" type="file">
						</div>
					</div>
					<div></div>
					<button>reviewの登録</button>
				</div>
			</form>

		</div>
	</div>

	<hr>

	<script type="text/javascript" src="js/mark_map2.js"></script>
	<script type="text/javascript" src="js/reviewfunction.js"></script>
	
	<script>
  function callReviewList(title) {
    // reviewlistC 함수 호출 또는 해당 함수를 원하는 동작으로 대체해주세요
    // 예시: 페이지 이동
    window.location.href = "reviewlistC?titleSearch=" + encodeURIComponent(title);
  }
</script>
	

</body>
</html>