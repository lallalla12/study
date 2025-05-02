<%@ page import ="utils.CookieManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// cookiemanager클래스를 이용하여 이름이 loginid인 쿠키를 읽어와 loginid에 저장
String loginId = CookieManager.readCookie(request, "loginId");


String cookieCheck = "";
// 쿠키에 저장된 아이디가 있다면, 즉 loginid에서 빈 문자열 외의 문자열을 저장해뒀다면, 
if (!loginId.equals("")){
	cookieCheck = "checked";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie - 아이디 저장하기</title>
</head>
<body>
	<h2> 로그인 페이지</h2>
	<form action = "IdSaveProcess.jsp" method="post">
		아이디 : <input type="text" name = "user_id" value = "<%= loginId %>" />
			<input type="checkbox" name="save_check" value="Y" <%= cookieCheck %> />
			아이디 저장하기
		<br>
		패스워드 : <input type="text" name ="user_pw">
		<br>
		<input type="submit" value="로그인하기">
	</form>
</body>
</html>