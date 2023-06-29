<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="wrap">
    <div class="info">
        <div class="title">${hotels.title }</div>
        <div class="body">
            <div class="img">
                <img src="https://cfile181.uf.daum.net/image/250649365602043421936D" width="73" height="70">
            </div>
            <div class="desc">
                <div class="ellipsis">${hotels.address }</div>
                <div class="jibun ellipsis">${hotels.roadaddress }</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>