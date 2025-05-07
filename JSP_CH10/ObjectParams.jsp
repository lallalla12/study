<%@ page import="common.Person" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어(EL) - 객체 매개변수</title>
</head>
<body>
	<%
	// Person객체, 문자열객체 integer 객체를 생성한 후 reqeust 영역에 저장
	request.setAttribute("personObj", new Person("홍길동",33));
	request.setAttribute("stringObj", "나는 문자열");
	request.setAttribute("interObj", new Integer(99));
	%>
	<!-- 액션 태그를 통해 포워드 -->
	<jsp:forward page="ObjectResult.jsp">
		<!-- 10과 20도 포워드된 페이지로 함께 전달 -->
		<jsp:param value="10" name="firstNum"/>
		<jsp:param value="20" name="secondNum"/>
	</jsp:forward>
</body>
</html>