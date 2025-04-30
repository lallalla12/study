<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - UseBean</title>
</head>
<body>
	<h2> useBean 액션 태그 </h2>
	<h3>자바빈즈 생성하기</h3>
	<!-- common 패키지의 person 클래스로 person이라는 자바빈즈를 생성해 request 영역에 저장 -->
	<jsp:useBean id = "person" class = "common.Person" scope="request"/>
	
	<h3>setProperty 액션 태그로 자바빈즈 속성 지정하기</h3>
	<!--  세터를 이용하여 person 자바빈즈의 name과 age변수 값을 설정 -->
	<jsp:setProperty name="person" property="name" value="임꺽정"/>
	<jsp:setProperty name="person" property="age" value="41"/>
	
	<h3>getProperty 액션 태그로 자바빈즈 속성 읽기</h3>
	<ul><!-- 게터를 이용해 자바빈즈에서 멤버 변수의 값을 출력 -->
		<li> 이름: <jsp:getProperty name="person" property="name"/></li>
		<li> 나이: <jsp:getProperty name="person" property="age"/></li>
	</ul>
</body>
</html>