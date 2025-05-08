<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!-- 변수 선언 -->
<!-- 네가지 영역 모두 똑같은 이름의 변수로 값을 저장 -->
<!-- 영역을 지정하지 않으면 가장 좁은 영역인 page영역이 저장됨 -->
<c:set var="scopeVar" value="Page Value"/>
<c:set var="scopeVar" value="Result Value" scope="request"/>
<c:set var="scopeVar" value="Session Value" scope="session"/>
<c:set var="scopeVar" value="Application Value" scope="application"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - remove</title>
</head>
<body>
	<h4>출력하기</h4>
	<ul>
		<!-- 영역을 지정하지 않으면 가장 좁은 영역인 page영역이 저장됨 -->
		<li> scopeVar : ${ scopeVar }</li>
		<li>requestScope.scopeVar : ${ requestScope.scopeVar }</li>
		<li>sessionScope.scopeVar : ${ sessionScope.scopeVar }</li>
		<li>applicationScope.scopeVar : ${ applicationScope.scopeVar }</li>
	</ul>
	
	<h4>session 영역에서 삭제하기</h4>
	<!-- scope속성을 sesison으로 지정하여 session영역에 지정된 변수만 삭제 -->
	<c:remove var="scopeVar" scope="session"/>
	<ul>	
		<!-- 변수가 삭제되었으므로 아무 값도 출력되지 않음 -->
		<li>sessionScope.scopeVar : ${ sessionScope.scopeVar }</li>
	</ul>
	
	<h4>scope 지정 없이 삭제하기</h4>
	<!-- scope속성을 지정하지 않고 삭제하였기에 4가지 영역 전체에서 scopVar를 삭제 -->
	<c:remove var="scopeVar"/>
	<ul>
		<!-- 출력 결과는 없음 -->
		<li>scopeVar : ${ scopeVar }</li>
		<li>requestScope.scopeVar : ${ requestScope.scopeVar }</li>
		<li>applicationScope.scopeVar : ${ applicationScope.scopeVar }</li>
	</ul>
</body>
</html>