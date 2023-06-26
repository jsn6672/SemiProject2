<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/overlaycustom.css">

<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f6d7d797f4c680fd25e3195c23d98ca&libraries=services"></script>
</head>

<body>


	<div class="container_hm">
		<div class="hotel_list">
			<input type="hidden" name="page">

			<div class="hotel_search">
				<form action="roomSearchC">
					<input name="hotelsearch" type="text">
					<button>검색</button>
				</form>
			</div>
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
	</div>
	 -->

			<br>


			<c:choose>
				<c:when test="${empty hotels }">
					<span>검색결과가 없습니다.</span>
				</c:when>
				<c:otherwise>

					<c:forEach items="${hotels }" var="h">
						<div class="hotel_content" data-roadaddress="${h.r_roadaddress}"
							data-title="${h.r_title}" data-introduction="${h.r_introduction}"
							data-imgpath="${h.r_imgpath}" data-tag="${h.r_tag}"
							onclick="moveToLocationByAddress(this.dataset.roadaddress, this.dataset.title, this.dataset.introduction, this.dataset.imgpath, this.dataset.tag)">
							<div class="hotel_img">
								<img src="${h.r_imgpath }" alt="…">
							</div>

							<div class="hotel_info">
								<div class="hotel_title">${h.r_title }</div>
								<div class="hotel_roadaddress">
									<p>연락처 : ${h.r_phoneno }</p>
								</div>
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

				<form action="reviewRegC" method="post"
					enctype="multipart/form-data">
					<div style="text-align: center; border: 1px solid #dddddd">
						<div style="background-color: #eeeeee; text-align: center;">
							리뷰 & 평가</div>

						<div>
							<input name="reg_username" type="text" placeholder="사용자명">
							<input name="reg_content" type="text" placeholder="분류"> 
							<input name="reg_contentname" type="text" placeholder="장소">
						</div>

						<div>
							<textarea class="review_text" name="reg_text" placeholder="글 내용"></textarea>
						</div>
						<div>
							<input name="reg_img" class="photo" type="file"> 평점 
							<select	name="reg_starpoint">
								<option value="1">1</option>
								<option value="1.5">1.5</option>
								<option value="2">2</option>
								<option value="2.5">2.5</option>
								<option value="3">3</option>
								<option value="3.5">3.5</option>
								<option value="4">4</option>
								<option value="4.5">4.5</option>
								<option value="5">5</option>
							</select>
						</div>
						<div class="reg">
							<button class="reg">글 등록</button>
						</div>
					</div>
				</form>

		
			</div>

		</div>
	</div>


	<script type="text/javascript" src="js/mark_map2.js">
		
	</script>
</body>
</html>