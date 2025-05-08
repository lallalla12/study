<%@ page import="common.Person"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - forEach2</title>
</head>
<body>
	<h4>List 컬렉션 사용하기</h4>
	<%
	// Person 객체를 담은 리스트 컬렉션을 준비
	LinkedList<Person> lists = new LinkedList<Person>();
	lists.add(new Person("맹사성", 34));
	lists.add(new Person("장영실", 44));
	lists.add(new Person("신숙주", 54));
	%>
	<!-- JSTL에서 사용하기 위해 set태그를 이용해 변수로 설정 -->
	<c:set var="lists" value="<%= lists %>" />
	<!-- 리스트 컬렉션을 출력하기 위해 forEach 태그의 items속성에 설정 -->
	<c:forEach items="${ lists }" var="list">
		<li> 
			<!-- 루프 내에서 각 객체의 이름과 나이를 출력 -->
			이름: ${ list.name }, 나이 :${ list.age }
		</li>
	</c:forEach>
	
	<h4>Map 컬렉션 사용하기</h4>
	<%
	// 앱 컬렉션 생성 후 키와 함께 객체 세개를 저장
	Map<String,Person> maps = new HashMap<String,Person>();
	maps.put("1st", new Person("맹사성",34));
	maps.put("2nd", new Person("장영실",44));
	maps.put("3rd", new Person("신숙주",54));
	%>
	<c:set var="maps" value="<%= maps %>" />
	
	<!-- 컬렉션을 순회하면서 키와 값을 출력 -->
	<c:forEach items="${ maps }" var="map">
		<li>Key => ${ map.key } <br/>
			Value => 이름 : ${map.value.name }, 나이 : ${ map.value.age }</li>
	</c:forEach>
</body>
</html>