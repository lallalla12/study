<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - request</title>
</head>
<body>
<%
// 전송된 값이 한글인 경우 깨짐 현상이 발생할 수 있기에
request.setCharacterEncoding("UTF-8");
// 전송되는 값이 하나라면 getParameter()메서드로 받을 수 있음
String id = request.getParameter("id");
String sex = request.getParameter("sex");
// 값이 2개 이상이면 String 배열로 반환함.
String[] favo = request.getParameterValues("favo");
String favoStr = "";
if(favo != null){
	// for문을 이용해 String 배열에 담긴 값들을 하나의 문자열로 합침
	for(int i = 0 ; i<favo.length; i++){
		favoStr += favo[i] + "";
	}
}
// textera 태그는 텍스트를 여러 줄 입력할 수 있기에 출력시에는 엔터키를 <br>태그로 변환해야 줄바꿈이 반영됨, 특수문자는 \r\n
String intro = request.getParameter("intro").replace("\r\n","<br>");
%>
<ul>
	<li>아이디 : <%= id %></li>
	<li>성별 : <%= sex %></li>
	<li>관심사항 : <%= favoStr %></li>
	<li>자기소개 : <%= intro %></li>

</ul>
</body>
</html>