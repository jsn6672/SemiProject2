<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="hm/css/overlaycustom.css">
<link rel="stylesheet" href="hm/css/review.css">
<title>Insert title here</title>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f6d7d797f4c680fd25e3195c23d98ca&libraries=services"></script>
</head>

<body>
	<div class="container_hm">
		<div class="subcontainer_hm">
			<input type="hidden" name="page">

			<div class="left-side">
				<div class="hotel_search">
					<form action="roomSearchC">
						<input name="hotelsearch" type="text">
						<button>검색</button>
					</form>
				</div>
				<div class="hotel_list">
					<br>
					<c:choose>
						<c:when test="${empty hotels or hotels == null}">
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
										<input type="hidden" name="hm_cid" value="${h.r_cid }">
										<input type="hidden" name="hm_title" value="${h.r_title }">
									</div>
									<div class="button_list">
										<!-- 								<form action="reviewlistC" method="get"> -->
										<%-- 									<button name="titleSearch" value="${h.r_title }">리뷰 보기</button> --%>
										<!-- 								</form> -->


										<button name="titleSearch"
											onclick="callReviewList('${h.r_title }')">리뷰 보기</button>
										<button
											onclick="hmOpenReviewWrite('${h.r_cid }', '${h.r_title }')">리뷰
											작성</button>
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
				<!-- 			<div> -->
				<!-- 				<button onclick="redirectToHC2()">일본어 전환</button> -->
				<!-- 			</div> -->


				<input type="hidden" id="place" value="${param.place }">
				<div id="hm_map"></div>

				<div class="review_list">
					<div>
						<c:choose>
							<c:when test="${empty reviews } ">
								<span class="center">검색결과가 없습니다.</span>
							</c:when>
							<c:otherwise>
								<c:forEach items="${reviews }" var="g">
									<div class="review_container">
										<div class="review_item">

											<div class="review_item">
												<div id="review_grade">
													<c:forEach begin="1" end="${g.r_grade}">
      													★ 
													</c:forEach>
													<c:forEach begin="1" end="${5 - g.r_grade}">
      													☆ 
													</c:forEach>
												</div>
											</div>

										</div>
										<div id="review_list_text">${g.r_text }</div>
										<div id="review_list_item">
											<div id="title">${g.r_title }</div>
											<div id="date">${g.r_date }</div>
										</div>
										<!-- 리뷰 삭제 버튼 -->
										<c:choose>
											<c:when test="${g.r_name == account.name }">
												<div class="review-delete">
													<div class="writer">${g.r_name }</div>
													<form id="buttonD" action="reviewDeleteC" method="get"
														onsubmit="return confirmDelete();">
														<br> <input type="hidden" name="cid"
															value="${g.r_cid }"> <input type="hidden"
															name="no" value="${get.r_no }">
														<button type="submit" name="deleteReview"
															value="${g.r_no }">삭제</button>
													</form>
												</div>
											</c:when>
											<c:otherwise>
												<div class="review-delete">
													<div class="writer">${g.r_name }</div>
													<form id="buttonD" action="reviewDeleteC" method="get"
														onsubmit="return confirmDelete();">
														<br> <input type="hidden" name="cid"
															value="${g.r_cid }"> <input type="hidden"
															name="no" value="${get.r_no }">
													</form>
												</div>
											</c:otherwise>
										</c:choose>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 리뷰 작성 모달 창 -->
	<div id="hmReviewWrite" class="hm-review-write">
		<div class="hm-review-content-write">

			<h2>리뷰를 작성해주세요!</h2>
			<form action="reviewRegC" method="post" enctype="multipart/form-data">
				<div>
					<input hidden="cid2" name="hm_r_cid"> <input
						hidden="title2" name="hm_r_title">
					<div class="rating">
						<span class="star" data-value="1">☆</span> <span class="star"
							data-value="2">☆</span> <span class="star" data-value="3">☆</span>
						<span class="star" data-value="4">☆</span> <span class="star"
							data-value="5">☆</span> <input type="hidden"
							name="hm_reviewGrade" id="starpoint">
					</div>

					<br>
					<div class="reviewname">
						<input placeholder="제목" name="hm_r_reviewname">
					</div>
					<!-- 					<br> -->
					<div class="reviewtext">
						<textarea name="hm_r_text" rows="10" cols="70"></textarea>
					</div>
					<br>
					<!-- 					<div> -->
					<!-- 						<div class="reviewimg"> -->
					<!-- 							사진 <input name="hm_r_pic" type="file"> -->
					<!-- 						</div> -->
					<!-- 					</div> -->
					<br>
					<div class="reg_btn">
						<button>리뷰 등록하기</button>
					</div>
					<span onclick="hmCloseReviewWrite()" class="hm-close">&times;</span>
				</div>
			</form>

		</div>
	</div>


	<hr>

	<script type="text/javascript" src="hm/js/mark_map2.js"></script>
	<script type="text/javascript" src="hm/js/reviewfunction.js"></script>


	<script>
		function callReviewList(title) {
			// reviewlistC 함수 호출 또는 해당 함수를 원하는 동작으로 대체해주세요
			// 예시: 페이지 이동
			window.location.href = "reviewlistC?titleSearch="
					+ encodeURIComponent(title);
		}

		function redirectToHC2() {
			window.location.href = "com/hm/jp/HC2.java";
		}
	</script>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
<script type="text/javascript" src="js/starpoint.js"></script>
</html>