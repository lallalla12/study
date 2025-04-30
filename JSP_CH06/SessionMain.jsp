<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");			// 날짜 표시 형식

long creationTime = session.getCreationTime();							// 최초 요청(세션 생성) 시각
// 세션 최초 요청(세션 생성)시각을 구해, 지정한 날짜 표시 형식에 맞는 문자열로 바꿔줌
String creationTimeStr = dateFormat.format(new Date(creationTime));

long lastTime = session.getLastAccessedTime();							// 마지막 요청 시각
// 마지막 요청 시각을 구해, 지정한 날짜 표시 형식에 맞는 문자열로 바꿔줌
String lastTimeStr = dateFormat.format(new Date(lastTime));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<h2> Session 설정 확인 </h2>
	<ul>
			<!--  web.xml에서 설정한 세션 유지 시간을 출력 -->
		<li>세션 유지 시간 : <%= session.getMaxInactiveInterval() %> </li>
			<!--  웹 브라우저에 생성된 세션 ID를 출력 -->
		<li>세션 아이디 : <%= session.getId() %> </li>
			<!--  최초 요청 시각과 마지막 요청 시각을 출력 -->
		<li>최초 요청 시각 : <%= creationTimeStr %> </li>
		<li>마지막 요청 시각 : <%= lastTimeStr %> </li>
	</ul>
</body>
</html>