<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="sj-review">
				<div class="sj-review-content">
					<input hidden id="g_id_s">
					<h2>Review</h2>
					<button
						onclick="sjOpenReviewWrite(document.getElementById('g_id_s').value)">Write</button>

					<c:forEach var="gs" items="${gourmets }">
						<table>

							<tr>
								<td>이미지</td>
								<td>이미지</td>
							</tr>
							<tr>
								<td>이미지</td>
								<td>이미지</td>
							</tr>
							<tr>
								<td>평점</td>
								<td>${g.gm_grade }</td>
							</tr>
							<tr>
								<td>작성일</td>
								<td>${g.gm_date }</td>
							</tr>
							<tr>
								<td>작성자</td>
								<td>${g.gm_l_no }</td>
							</tr>
							<tr>
								<td>추천메뉴</td>
								<td>${g.gm_menu }</td>
							</tr>
							<tr>
								<td>내용</td>
								<td id="g-review">${g.gm_review }</td>
							</tr>
							<tr>
								<td><button onclick>Modify</button></td>
								<td><button>Delete</button></td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</div>

</body>
</html>