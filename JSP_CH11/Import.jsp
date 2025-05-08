<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - import</title>
</head>
<body>
	<!-- otherpage에 전달할 변수를 request영역에 저장 -->
	<c:set var="requestVar" value="MustHave" scope="request"/>
	<!-- var속성을 지정했으므로 페이지의 내용이 즉시 삽입되지 않고 변수 contents에 저장 -->
	<c:import url="/JSP_CH11/OtherPage.jsp" var="contents">
		<c:param name="user_param1" value="JSP"/>
		<c:param name="user_param2" value="기본서"/>
	</c:import>
	
	<h4> 다른 문서 삽입하기 </h4>
	${ contents }
	
	<h4> 외부 자원 삽입하기</h4>
	<iframe src="GoldPage.jsp" style="width:100%; height:600px;"></iframe>
</body>
</html>