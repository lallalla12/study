<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table border="1" width="90%">
	<tr>
		<td align="center">
		<!--  로그인 여부에 따른 메뉴 변화 -->
		<% if (session.getAttribute("UserId") == null) { %>
			<a href="../JSP_CH06/LoginForm.jsp">로그인</a>
		<% } else { %>
			<a href="../JSP_CH06/Logout.jsp">로그인</a>
		<% } %>	
			<!--  8장과 9장의 회원제 게시판 프로젝트에서 사용할 링크 -->
			&nbsp;&nbsp;&nbsp;	<!--  메뉴 사이의 공백 확보용 특수 문자 -->
			<a href="#"> 게시판(페이징x)</a>
			&nbsp;&nbsp;&nbsp;
			<a href="#"> 게시판(페이징o)</a>
		</td>
	</tr>
</table>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>