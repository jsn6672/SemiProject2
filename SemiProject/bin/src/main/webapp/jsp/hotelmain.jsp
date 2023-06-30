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
						<span>검색결과가 없습니다.</span>
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
										<p>연락처 : ${h.r_phoneno }</p>
										<p>주소 : ${h.r_address }</p>
									</div>
									<button
										onclick="hmOpenReviewWrite('${h.r_pk }', '${h.r_title }')">리뷰
										작성</button>
									<input type="hidden" name="hm_pk" value="${h.r_pk }">

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
					<tr>
						<td>번호</td>
						<td>이름</td>
						<td>제목</td>
						<td>별점</td>
					</tr>
				
				</table>
			</div>
		</div>
		<!-- 리뷰 작성 모달 창 -->
		<div id="hmReviewWrite" class="hm-review-write">
			<div class="hm-review-content-write">
				<span onclick="hmCloseReviewWrite()" class="hm-close">&times;</span>
				<h2>리뷰를 작성해주세요!</h2>
				<form action="reviewRegC" method="post"
					enctype="multipart/form-data">
					<div>
						<div>
							<input hidden="" name="hm_r_pk" value=""> <input
								hidden="" name="hm_r_title">
							<div>
								평점 <select id="hm-reviewGrade" name="hm_reviewGrade">
									<option value="1">★</option>
									<option value="2">★★</option>
									<option value="3">★★★</option>
									<option value="4">★★★★</option>
									<option value="5">★★★★★</option>
								</select>
							</div>
						</div>
						<div>
							<div>내용</div>
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
						<button>리뷰 등록하기</button>
					</div>
				</form>

			</div>
		</div>
	</div>
	<!-- 리뷰 모달창 -->
	<div id="hmReview" class="hm-review-check">
		<div class="hm-review-content-check">
			<input hidden id="h_pk_s"> <input hidden id="h_title_s">
			<span onclick="hmCloseReview()" class="hm-close">&times;</span>
			<h2>Review</h2>
			<button onclick="hmOpenReviewWrite()">Write</button>
			<p>
			<div>
				<div>
					<div>이미지</div>
				</div>
				<div>
					<div>제목</div>
				</div>
				<div>
					<div>작성자</div>
				</div>
				<div>
					<div>평점</div>
					<div></div>
				</div>
				<div>
					<div>내용</div>
				</div>
				<div>
					<div>
						<button>Modify</button>
					</div>
					<div>
						<button>Delete</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 리뷰 모달 확인 창 끝 -->


	<script type="text/javascript" src="js/mark_map2.js"></script>
	<script type="text/javascript" src="js/reviewfunction.js"></script>

</body>
</html>