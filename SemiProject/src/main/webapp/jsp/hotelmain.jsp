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
	<div>
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
										<input type="hidden" name="hm_r_cid" value="${h.r_cid }">
										<input type="hidden" name="hm_r_title" value="${h.r_title }">
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
				<input type="hidden" id="place" value="${param.place }">
				<div id="hm_map"></div>

				<table class="column">
					<thead>
				</table>

				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>이름</th>
					<th>제목</th>
					<th>별점</th>
					<th>작성 일</th>
				</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach items="${review" var="r">
							<th>${r.r_cid }</th>
							<th>${r.r_id }</th>
							<th>${r.r_title }</th>
							<th>${r.r_reviewname}</th>
							<th>${r.r_grade }</th>
							<th>${r.r_date }</th>
						</c:forEach>
					</tr>
				</tbody>

			</div>


		</div>
	</div>
	<!-- 리뷰 작성 모달 창 -->
	<div id="hmReviewWrite" class="hm-review-write">
		<div class="hm-review-content-write">
			<span onclick="hmCloseReviewWrite()" class="hm-close">&times;</span>
			<h2>리뷰를 작성해주세요!</h2>
			<form action="reviewRegC" method="post" enctype="multipart/form-data">
				<div>
					<div>
						<input hidden="" id="modal_cid" name="hm_r_cid"> <input
							hidden="" id="modal_title" name="hm_r_title">
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
						<input type="text" class="r_reviewname" name="hm_r_reviewname"
							placeholder="제목">
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


	<script type="text/javascript" src="js/mark_map2.js"></script>
	<script type="text/javascript" src="js/reviewfunction.js"></script>

</body>
</html>