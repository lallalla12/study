<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OtherPage.jsp</title>
</head>
<body>
	<li>저장된 값: ${ requestVar }</li>
	<li>매개변수 1: ${ param.user_param1 }</li>
	<li>매개변수 2: ${ param.user_param2 }</li>
</body>
</html>