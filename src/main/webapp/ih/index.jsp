<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="css/toolbar.css">
 <link rel="stylesheet" type="text/css" href="css/quick_menu.css">
 <link rel="stylesheet" type="text/css" href="css/widgetWheel.css">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>


<!-- <script type="text/javascript" src="js/tour.js"></script> -->
</head>
<body>
<div class="toolbar">
      <div class="toolbar-info">
         <ul class="toolbar_nav">
				<li><a href="tourC">여행</a></li>
				<li><a href="roomAllsearchC">숙소</a></li>
				<li><a href="GourmetC">음식</a></li>
				<li><a href="RentShopC">렌트카</a></li>
				<li><a href="JsnHC">전통술</a></li>
			</ul>
         <div class="time"></div>
         <div class="icon"></div>
         <div class="temp"></div>
         <a href="Main_HC" class="quick_btn">홈</a> <br>
         <!-- 퀵버튼 -->
         <jsp:include page="${loginPage }"></jsp:include>
         <!-- 로그인버튼 -->
      </div>
   </div>
  <!--  <div class="popup" id="signup">
      <div class="sign_up">
         <h1 class="signup_header">안녕, 육지사람 :-)</h1>
         <br>
         <form action="loginC" method="post">
            <div class="int-area">
               <label for="id">USER ID</label> <input type="text" name="id"
                  id="login_id" autocomplete="off">
            </div>
            <div class="int-area">
               <label for="id">USER PW</label> <input type="password" name="pw"
                  id="login_pw" autocomplete="off">
            </div>
            <div class="btn-area">
               <button class="loginConfirm_btn" id="btn" type="submit">LOGIN</button>
            </div>
         </form>
         <div class="caption">
            <a id="findPwd_btn" href="#pwd_Changer_Popup">Forgot Password?</a><br>
            <a href="SignUp.jsp">Join to us</a>
         </div>
      </div>
   </div> -->
   <br>
   <br>
   <br>
   <br>

	<table id="site">
		<tr>
			<td align="center"><jsp:include page="${contentPage }"></jsp:include>
			</td>

		</tr>

	</table>
	
<!-- Jquery 받아오기 -->
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>

<script>
/* 날씨를 받아오자 재환아 */
   $
         .getJSON(
               'https://api.openweathermap.org/data/2.5/weather?q=Jeju City&appid=e4ef05580f862e66fd424cf8275dc13f&units=metric',
               function(result) {
                  var temp = Math.round(result.main.temp);
                  var wind = result.wind.speed;
                  var ct = result.dt;

                  function convertTime(t) {
                     var week = new Array('일요일', '월요일', '화요일', '수요일',
                           '목요일', '금요일', '토요일');
                     var days = new Date().getDay();
                     var today = week[days];
                     var ot = new Date(t * 1000);
                     var hr = ot.getHours();
                     var m = ot.getMinutes();

                     if (hr >= 12 && hr <= 24) {
                        return today + ' /' + ' 오후 ' + hr + ' : ' + m
                     } else {
                        return today + ' /' + ' 오전 ' + hr + ' : ' + m
                     }
                  }
                  function temps(temp) {
                     return temp + '℃'
                  }

                  function winds(wind) {
                     return '풍속 ' + wind + ' m/s'
                  }

                  var wiconUrl = '<img src="https://openweathermap.org/img/wn/'+result.weather[0].icon+'@2x.png" alt="'+result.weather[0].description+'">'
                  $('.icon').html(wiconUrl);
                  var currentTime = convertTime(ct);
                  $('.time').html(currentTime);
                  var currentTemp = temps(temp);
                  $('.temp').html(currentTemp);
                  var windSpeed = winds(wind);
                  $('.wind').html(windSpeed);
               });
</script>
	
</body>
</html>