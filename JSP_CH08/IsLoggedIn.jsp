<%@ page import= "utils.JSFunction" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// UserId라는 속성값이 있는지 확인
if (session.getAttribute("UserId") == null){
	// null일경우 로그인하지 않았다는 뜻
	// 로그인하지 않았다면 alert창을 띄운후 , LoginForm으로 이동
	JSFunction.alertLocation("로그인 후 이용해주십시오", "../JSP_CH06/LoginForm.jsp",out);
	
	// 특정 조건에서 실행을 멈출때에는 return문을 써야함.
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>