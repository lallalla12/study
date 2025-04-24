<%@ page import = "java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - request</title>
</head>
<body>
	<h2> 3. 요청 헤더 정보 출력하기</h2>
	<%
	// getHeaderNames()는 모든 요청 헤더의 이름을 반환함. 
	Enumeration headers = request.getHeaderNames();
	// hasMoreElements()를 이용해 출력할 요청 헤더명이 더 있는지 확인함.
	while (headers.hasMoreElements()){
		// 헤더명이 더 있다면 요청 헤더의 이름을 얻어온 다음
		String headerName = (String)headers.nextElement();
		// getHeader()에 헤더명을 건네 헤더값을 얻어옴
		String headerValue = request.getHeader(headerName);
		out.print("헤더명 : " + headerName + ", 헤더값 : " + headerValue + "<br>");
	}
	%>
</body>
</html>