<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="/sample/ex01">SampleController에서 GetMapping이 ex01인 곳으로 이동</a>

<form action="/sample/ex01" method="get">
	이름 : <input type="text" name="name">
	나이 : <input type="text" name="age">
	<input type="submit" value="SampleController에서 GetMapping이 ex01인 곳으로 이동">
</form>

<a href="/sample/ex02List?ids=111&ids=222&ids=333">
	SampleController에서 GetMapping이 ex02인 곳으로 이동</a><br>
	
<form action ="/sample/ex02List" method="get">
	<input type="checkbox" name="ids" value="111">111
	<input type="checkbox" name="ids" value="222">222
	<input type="checkbox" name="ids" value="333">333<br>
	<input type="submit" value="SampleController에서 GetMapping이 ex02인 곳으로 이동">
</form>

<a href="/sample/ex03?title=test&dueDate=2018-01-01">
	SampleController에서 GetMapping이 ex03인 곳으로 이동</a><br>
	
<form action ="/sample/ex03" method="get">
	제목<input type="text" name="title">
	날짜<input type="date" name="dueDate"><br>
	<input type="submit" value="SampleController에서 GetMapping이 ex03인 곳으로 이동">
</form>

</body>
</html>
