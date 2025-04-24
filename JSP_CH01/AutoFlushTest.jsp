<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="1kb" autoFlush="false" %>	<%-- 버퍼 설정 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 버퍼 채우기 --%>
<%
	for (int i=1; i<=100; i++){		
		out.println("abcde12345");
	}
%>
</body>
</html>