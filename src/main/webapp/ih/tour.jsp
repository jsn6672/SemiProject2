<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> --%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="ih/js/language.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="stylesheet" href="ih/css/overlay1.css">
<link rel="stylesheet" type="text/css" href="ih/css/style1.css">

<title>제주관광</title>

</head>



<body>
	<div class="container">
		<div class="row justify-content-center mt-5" id="top-main">
			<div class="col-md-6">
				<form action="tourSearchC">
					<h1>추천관광명소</h1>
					<input type="text" name="searchInput">
					<button>검색</button>
				</form>
			</div>
		</div>

		<div class="row mt-5">





			<!-- <div class="language-btns">
				<button class="lang-btn" data-lang="ko">한국어</button>
				<button class="lang-btn" data-lang="ja">日本語</button>
			</div> -->






			<div class="col-md-4">
				<div class="sc">
					<c:forEach items="${tourPlaces}" var="r">
						<div class="col-12">
							<div class="card" style="width: 100%;">
								<img src="${r.r_imgpath}" class="card-img-top" alt="..."
									data-roadaddress="${r.r_roadaddress}"
									data-introduction="${r.r_introduction}"
									data-imgpath="${r.r_imgpath}"
									data-contentsid="${r.r_contentsid}"
									onclick="removeOverlays(); moveToLocationByAddress(this.dataset.roadaddress, this.dataset.introduction, this.dataset.imgpath, this.dataset.contentsid)">
								<div class="card-body">
									<h5 class="card-title">관광지 : ${r.r_title }</h5>
									<p class="card-text">연락처 : ${r.r_phoneno }</p>
									
									<%-- p class="card-text">별점평균:
									${getAverageStarpoint(r.r_title)}</p> --%> 
									<button class="review-btn" value="${r.r_contentsid }">리뷰 보기</button>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="col-md-8">
				<!-- 지도 -->
				<div id="map">맵</div>

				<!-- 글쓰기 폼 -->
				  <div class="all-table">
					<!-- <table class="table"
						style="text-align: center; border: 1px solid #dddddd">
						<tr>
							<th style="background-color: #fafafa; text-align: center;">글
								번호</th>
							<th style="background-color: #fafafa; text-align: center;">이름</th>
							<th style="background-color: #fafafa; text-align: center;">제목</th>
							<th style="background-color: #fafafa; text-align: center;">내용</th>
							<th style="background-color: #fafafa; text-align: center;">별점</th>
							<th style="background-color: #fafafa; text-align: center;">사진</th>
						</tr>
					</table> -->
					<input type="hidden" value="${sessionScope.account.id }"
						id="loginId">
					<table id="ajaxTable"
						style="text-align: center; border: 1px solid #dddddd"></table>
				</div>  
			</div>
		</div>




		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header"></div>
					<div class="modal-body">
						<!-- 리뷰 작성 양식  -->
						<form action="RegReviewC" method="post">
							<div class="table-responsive">
								<table class="table table-striped">
									<tbody>
										<tr>
											<td><input type="text" class="form-control"
												placeholder="이름" name="r_name"></td>
										</tr>
										<tr>
											<td><input type="text" class="form-control"
												placeholder="제목" name="r_title" maxlength="20"></td>
										</tr>
										<tr>
											<td><textarea class="form-control" placeholder="리뷰 내용"
													name="r_review" maxlength="200" style="height: 350px;"></textarea>
											</td>
										</tr>
										<tr>
											<td>
												<div class="rating">
												<input type="hidden" id ="r_contentsId" name="r_contentsId" value="">
													<span class="star" data-value="1">☆</span> <span
														class="star" data-value="2">☆</span> <span class="star"
														data-value="3">☆</span> <span class="star" data-value="4">☆</span>
													<span class="star" data-value="5">☆</span> <input
														type="hidden" name="r_starpoint" id="starpoint">
												</div>
											</td>
										</tr>
										<tr>
											<td><input type="hidden" class="form-control-file"
												name="r_id" value="${account.id }"></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="modal-footer">
								<input type="submit" class="btn btn-primary" value="리뷰 작성">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>




		<div class="btn-toolbar" role="toolbar"
			aria-label="Toolbar with button groups">
			<div class="btn-group" role="group" aria-label="First group">
				<%
				if (request.getAttribute("prevPageNo") != null && (Integer) request.getAttribute("prevPageNo") > 0) {
				%>
				<a href="TourPageC?p=<%=request.getAttribute("prevPageNo")%>"
					class="btn btn-secondary">이전</a>
				<%
				}
				%>

				<%
				for (int i = (Integer) request.getAttribute("groupStartPage"); i <= (Integer) request
						.getAttribute("groupEndPage"); i++) {
				%>
				<a href="TourPageC?p=<%=i%>" class="btn btn-secondary"><%=i%></a>
				<%
				}
				%>

				<%
				if (request.getAttribute("nextPageNo") != null && (Integer) request.getAttribute("nextPageNo") > 0) {
				%>
				<a href="TourPageC?p=<%=request.getAttribute("nextPageNo")%>"
					class="btn btn-secondary">다음</a>
				<%
				}
				%>
			</div>
		</div>
	</div>

	<!-- script 태그 내부 내용 생략 -->
</body>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=36fb26454f751b31d965308b916a7861&libraries=services"></script>
<script type="text/javascript" src="ih/js/getReview.js"></script>
<script type="text/javascript" src="ih/js/star.js" defer="defer"></script>
<script type="text/javascript" src="ih/js/map.js" defer="defer"></script>
<script type="text/javascript">
/*
var request = new XMLHttpRequest();
function searchFunction(){
	request.open("post", "./TourReviewC?r_name=" + encodeURIComponent(document.getElementById("r_name").value),true);
	request.onreadystatechange = searchProcess;
	request.send(null);
}
function searchProcess(){
	if(request.readyState == 4 && request.status == 200){
		var object = JSON.parse(request.responseText);
		console.log(object);
		var result = object.result;
		for(var i = 0; i < result.length; i++){
			var row = table.insertRow(i);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			//var cell4 = row.insertCell(3);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			cell1.innerText = result[i].no;
			cell2.innerText = result[i].name;
			cell3.innerText = result[i].title;
			//cell4.innerText = result[i].content;
			cell4.innerText = result[i].review;
			cell5.innerText = result[i].starpoint;
			cell6.innerHTML = '<img src="/KIHimgFolder/' + result[i].img + '" alt="Image" style="width: 50px; height: 50px;">';
			//cell6.innerText = result[i].img;
			}
		}
	}
*/
</script>


<script type="text/javascript">
$(function() {
	  $("#ajaxTable").on("click", "button", function() {
	    console.log($(this));
	    let tr = $(this).parent().parent();
	    
	    let r_no = $(this).val();
	    $.ajax({
	      url: "TourReviewDelC",
	      type: "GET",
	      data: { r_no },
	      success: function() {
	        console.log('삭제성공');
	        $(tr).remove();
	      }
	    });
	  });
	  
	  
	  $(".review-btn").click(function() {
	    let id = $("#loginId").val(); // 로그인한 사람 아이
	    $("#ajaxTable").empty();
	    console.log($(this).val());
	    let r_contentsid = $(this).val();
	    console.log(id);
	    $.ajax({
	      url: "TourReviewC",
	      type: "POST",
	      data: { r_contentsid },
	      success: function(j) {
	        let json = JSON.parse(j);
	        console.log(json.result);
	        $.each(json.result, function(i, r) {
	          let tr = $("<tr></tr>").addClass("custom-table-row"); 
	          let td1 = $("<td></td>").addClass("custom-table-data").text(r.no);
	          let td2 = $("<td></td>").addClass("custom-table-data").text(r.name);
	          let td3 = $("<td></td>").addClass("custom-table-data").text(r.title);
	          let td4 = $("<td></td>").addClass("custom-table-data").text(r.review);
	          let td5 = $("<td></td>").addClass("custom-table-data").text(r.starpoint);
	          let td6 = $("<td></td>").append($("<button></button>").addClass("custom-button btn btn-danger").val(r.no).text("삭제"));
	          /*     if(id == user_id){
		  			let td6 = $("<td></td>").append($("<button></button>").addClass("custom-button btn btn-danger").val(r.no).text("삭제"));
				}else{
					let td6 = $("<td></td>").append($("<button></button>").addClass("custom-button btn btn-danger").val(r.no).text());;
			
				}    */
	          
	          
	          
	          let trtd = $(tr).append(td1).append(td2).append(td3).append(td4).append(td5).append(td6);
	          $("#ajaxTable").append(trtd);
	        });
	      }
	    });
	  });
	});
    	
    	
    	/*  if(id == r.name){
		  let td6 = $("<td><button value='"+r.no+"'>삭제</button></td>");
		}else{
		let td6 = $("<td> ^-^  </td>");
			
		}  */
    	
    </script>
    
    
    
    
</html>