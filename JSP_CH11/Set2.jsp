<%@ page import="common.Person"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Vector"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - set 2</title>
</head>
<body>
	<h4>List 컬렉션 이용하기</h4>
	<%
	// List 컬렉션을 생성하고
	ArrayList<Person> pList = new ArrayList<Person>();
	// Person 객체를 추가함
	pList.add(new Person("성삼문", 55));
	pList.add(new Person("박팽년", 60));
	%>
	<!-- 이 컬렉션을 request 영역에 personList라는 변수명으로 저장한 다음 -->
	<c:set var="personList" value="<%=pList%>" scope="request" />
	<ul>
		<!-- 다시 불러와서 출력 -->
		<li>이름 : ${ requestScope.personList[0].name }</li>
		<!-- 다른 영역에 똑같은 이름으로 저장한 속성이 없으므로 requestScope는 생략할 수 있음 -->
		<li>나이 : ${personList[0].age }</li>
	</ul>

	<h4>Map 컬렉션 이용하기</h4>
	<%
	// Map 컬렉션을 생성하고 Person객체를 저장함
	Map<String, Person> pMap = new HashMap<String, Person>();
	pMap.put("personArgs1", new Person("하위지", 65));
	pMap.put("personArgs2", new Person("이개", 67));
	request.setAttribute("personMap", pMap);
	%>
	<!-- request 영역에 변수명 personMap으로 저장하고  -->
	<c:set var="personMap" value="<%=pMap%>" scope="request" />
	<ul>
		<!-- 키를 통해 접근하여 출력함 같은 이유로 reqeustScope는 생략 가능 -->
		<li>이름 : ${ requestScope.personMap.personArgs2.name }</li>
		<li>나이 : ${ personMap.personArgs2.age }</li>
	</ul>
</body>
</html>