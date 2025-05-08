<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL- forTokens</title>
</head>
<body>
	<%
	// 콤마로 구분된 문자열을 준비함, 구분자는 다른 특수기호를 사용해도됨.
	String rgba = "Red,Green,Blue,Black";
	%>
	<h4>JSTL의 forTokens 태그 사용</h4>
	<!-- fortokens 태그의 items속성에는 문자열만 사용 할 수 있음. 
		 배열이나 컬렉션은 사용 불가능 delims는 구분자를 입력.
		 구분자를 기준으로 분리된 토큰은 var속성에 지정한 color 변수에 저장 -->
	<c:forTokens items="<%= rgba %>" delims="," var="color">
		<span style="color:${ color };"> ${ color }</span> <br>
	</c:forTokens>
</body>
</html>