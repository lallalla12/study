<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<h2> 로그인 페이지 </h2>
	
	<jsp:include page="../common/Link.jsp"/>
	
	
	<span style="color: red; font-size : 1.2em;">
		<%= request.getAttribute("LoginErrMsg") == null ?
				"" : request.getAttribute("LoginErrMsg") %>
	</span>
	
	<%
		// session 영역에 사용자 아이디가 저장되어 있는지 확인함, null이면 저장되지 않은것이므로 로그아웃 상태를 뜻함
	if (session.getAttribute("UserId") == null){				// 로그인 상태 확인
		// 로그아웃 상태
	%>
	<script>
		// validateForm()은 자바스크립트로 작성한 유효성 검사 함수, 아이디와 패스워드 중 빈 값이 있다면 경고창을 띄움
		function validateForm(form){
			if(!form.user_id.value){
				alert("아이디를 입력하세요.");
				return false;
			}
			if (form.user_pw.value == ""){
				alert("패스워드를 입력하세요.");
				return false;	
			}	
		}
	</script>
	<form action="LoginProcess.jsp" method="post" name="loginFrm"
		onsubmit="return validateForm(this);">
		아이디 : <input type = "text" name = "user_id" ><br>
		패스워드 : <input type = "password" name = "user_pw"> <br>
		<input type="submit" value="로그인하기">
	</form>
	
	<%
	} else {
	%>
		<!-- 로그인 된 상태  -->
		<%= session.getAttribute("UserName") %> 회원님, 로그인하셨습니다.<br>
		<a href="Logout.jsp">[로그아웃]</a>
	<%
	}
	%>
	
	
</body>
</html>