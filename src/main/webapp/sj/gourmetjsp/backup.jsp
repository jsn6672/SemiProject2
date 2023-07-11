<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="sj/gourmetcss/gourmet.css">
<script type="text/javascript" src="sj/gourmetjs/gourmet.js" defer></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=85af9840b8713b35481bb6ab8c998933&libraries=services"></script>
</head>
</head>
<body>

	<div class="container">
		<!-- gourmetResult의 전체 container -->



		<form action="GourmetSearchC" method="post">
			<select name="select">
				<option value="name">상호</option>
				<option value="location">위치</option>
			</select> <input name="input"></input>
			<button>search</button>
		</form>



		<div class="sj-viewcontainer" style="display: flex;">
			<!-- 결과와 지도를 묶는 div -->
			<div class="sj-result">
				<!-- 결과 뷰잉 div -->
				<c:forEach var="g" items="${gourmetInfos }" varStatus="status">
					<div style="border: 1px solid black; width: 300px">
						<br>${g.name }<br> <br> <span
							style="display: none;">${g.id }</span><br> ${g.tel }<br>
						${g.addr }<br> <br> ${g.menu }<br> 
						<input id="addr" name="addr" hidden="" value="${g.addr}"> 
						<input name="input" hidden="" value="${select}"> 
						<input name="select" hidden="" value="${input}">

						<button onclick="mapMake('${g.addr }','${g.name }','${g.img }')">Map</button>

						<%-- 						<button onclick="sjOpenReview('${g.id }')">Review</button>--%>

						<button class="review-btn">Review</button>
							<%-- <button onclick="sjOpenReviewWrite(${g.id})">Write</button> --%>
						<button onclick="sjOpenReviewWrite(document.getElementById('g_id_s').value)">Write</button> 

					</div>

					<div class="review-div-wrap">
						<c:forEach var="review" items="${g.reviews }">
							<div class="review-div style=" border: 1px solidred;">
								<div>${review.gm_grade }</div>
								<div>${review.gm_date }</div>
								<div>${review.gm_menu }</div>
								<div>${review.gm_review }</div>
							</div>
							<div> <hr> </div> 
						</c:forEach>

						<div>
						</div>
					</div>


				</c:forEach>
			</div>
			<!-- 결과 뷰잉 페이지 div 끝 -->

			<div>
				<!-- 지도 뷰잉 페이지 div -->
				<!-- 지도를 표시할 div 입니다 -->
				<div id="map"
					style="display: block; width: 950px; height: 250px; margin-right: auto"></div>
				<img id="markerImage" src=""
					style="width: 0px; height: 0px; display: none;">
			</div>
			<!-- 리뷰 뷰잉 모달창 -->



			<!-- 리뷰 모달창 끝 -->
			<!-- 지도 뷰잉 페이지 div 끝-->
		</div>
		<!-- 결과와 지도를 묶는 div 끝 -->




		<!-- 리뷰 작성 모달 창 -->
		<div id="sjReviewWrite" class="sj-review-write">
			<div class="sj-review-content-write">
				<input hidden name="g_id_s">
				<span onclick="sjCloseReviewWrite()" class="sj-close">&times;</span>
				<h2>리뷰를 작성해주세요!</h2>
				<p></p>

				<form action="GourmetReviewC" method="post"
					enctype="multipart/form-data">
					<table>

						<tr>
							<td>평점</td>
							<td><input hidden name="sj-r_id"> <select
								name="sj-reviewGrade">
									<option value="1">★</option>
									<option value="2">★★</option>
									<option value="3">★★★</option>
									<option value="4">★★★★</option>
									<option value="5">★★★★★</option>
							</select></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea name="sj-r_text" rows="10" cols="70"></textarea></td>
						</tr>
						<tr>
							<td>추천메뉴</td>
							<td><textarea name="sj-r_menu" rows="10" cols="70"></textarea></td>
						</tr>
						<!-- 		<tr>
						<td>사진</td>
						<td><input name="sj-r_pic" type="file"></td>
					</tr> -->
						<tr>
							<td>비밀번호</td>
							<td><input name="sj-r_pw"></td>
						</tr>
						<tr>
							<td><button>등록하기</button></td>
						</tr>
					</table>
				</form>


			</div>
		</div>


	</div>
	<!-- container div 끝 -->

	</div>



</body>
</html>

/*리뷰 모달창*/
function sjOpenReview(g_id) {
	console.log(g_id)
	var modal = document.getElementById("sjReview");
	let ids = document.getElementById("g_id_s");
	ids.value = g_id;

	modal.style.display = "block"; // 모달 창을 보이도록 설정
}




function sjCloseReview() {
	var modal = document.getElementById("sjReview");
	modal.style.display = "none"; // 모달 창을 숨김
}



