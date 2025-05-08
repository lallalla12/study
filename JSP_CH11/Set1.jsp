<%@ page import="java.util.Date" %>
<%@ page import = "common.Person" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core 태그를 사용하기 위해 taglib 지시어를 선언함  -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - set 1</title>
</head>
<body>
	<!-- 변수 선언 -->
	<!-- int directVar = 100;과 같음 -->
	<c:set var = "directVar" value="100"/>
	<!-- int elVar = directVar % 5;와 같음 -->
	<c:set var = "elVar" value="${ directVar mod 5}"/>
	<!-- Date expVar = new Date();와 같음 -->
	<c:set var = "expVar" value="<%= new Date() %>"/>
	<!-- 태그 사이에도 값을 지정할 수 있음 -->
	<c:set var = "betweenVar"> 변수값 요롷게 설정</c:set>
	
	<h4>EL을 이용해 변수 출력</h4>
	<ul>
		<li>directVar : ${ pageScope.directVar }</li>
		<li>elVar : ${ elVar }</li>
		<li>expVar : ${ expVar }</li>
		<li>betweenVar : ${ betweenVar }</li>
	</ul>
	
	<h4> 자바빈즈 생성 1 - 생성자 사용</h4>
	<!-- 자바빈즈 생성시 생성자를 통해 초깃값을 설정하고 request영역에 변수를 저장한 다음 -->
	<c:set var = "personVar1" value ='<%= new Person("박문수",50) %>'
		scope = "request"/>
	
	<ul>
		<!-- 다시 request영역에 저장된 자바빈즈를 출력함 -->
		<li>이름 : ${ requestScope.personVar1.name }</li>
		<li>나이 : ${ personVar1.age }</li>
	</ul>
	
	<h4> 자바빈즈 생성 2 - target, property 사용</h4>
	<c:set var="personVar2" value="<%= new Person() %>" scope="request"/>
	<c:set target="${personVar2 }" property="name" value="정약용"/>
	<c:set target="${personVar2 }" property="age" value="60"/>
	<ul>
		<li> 이름 : ${ personVar2.name }</li>
		<li> 나이 : ${ requestScope.personVar2.age }</li>
	</ul>
</body>
</html>