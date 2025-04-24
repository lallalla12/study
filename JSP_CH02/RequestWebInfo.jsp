<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - request</title>
</head>
<body>
	<h2> 1. 클라이언트와 서버의 환경정보 읽기</h2>
	<ul>
		<%-- getMethod()는 GET과 POST같은 전송 방식을 반환함. --%>
		<li>데이터 전송 방식 : <%= request.getMethod() %></li>
		<%-- 요청 주소를 반환함, URL은 호스트를 포함한 전체 주소 --%>
		<li> URL : <%= request.getRequestURL() %></li>
		<%-- 요청 주소를 반환함, URI는 호스트를 제외한 컨텍스트 루트부터의 주소 --%>
		<li> URI : <%= request.getRequestURI() %></li>
		<li> 프로토콜 : <%= request.getProtocol() %></li>
		<li> 서버명 : <%= request.getServerName() %></li>
		<li> 서버 포트 : <%= request.getServerPort() %></li>
		<%-- 클라이언트의 IP주소를 반환함 --%>
		<li> 클라이언트 IP 주소 : <%= request.getRemoteAddr() %></li>
		<%-- 요청 주소 뒷부분의 매개변수 전달을 위한 쿼리스트링 전체를 반환함. --%>
		<li> 쿼리스트링 : <%= request.getQueryString() %></li>
		<%-- 특정 키값을 얻어오려면 getParameter()메서드에 키값을 인수로 넣으면됨. --%>
		<li> 전송된 값 1 : <%= request.getParameter("eng") %></li>
		<li> 전송된 값 2 : <%= request.getParameter("han") %></li>
	</ul>
</body>
</html>