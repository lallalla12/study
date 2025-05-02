<%@ page import= "utils.CookieManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String loginId = CookieManager.readCookie(request, "loginId");

String cookieCheck = "";
if (!loginId.equals("")){
	cookieCheck = "checked";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
.input {
	border-radius: 100px;
	background-color: lightgray;
	border : 0px;
	height: 20px;
	padding : 5px;
	margin : 5px;
}
.btn {
	border-radius: 100px;
	border : 0px;
	width : 180px;
	height : 30px;
	margin : 5px;
	text-align :center;
}
#in {
	background-color:lightblue;
}
</style>
</head>
<body>
	<jsp:include page="../common/Share_Link.jsp"/>
	<h2>로그인</h2>
	<span style="color: lightpink; font-size : 1.2em;">
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
	<form action="Share_LoginProcess.jsp" method="post" name="loginFrm"
		onsubmit="return validateForm(this);">
		<input type = "text" name = "user_id" placeholder="ID" class="input" value="<%= loginId %>"><br>
		<input type = "password" name = "user_pw" placeholder="Password" class="input"> <br>
		<input type = "checkbox" name = "save_check" value="Y" <%= cookieCheck %>> 로그인 정보 저장 <br>
		<input type="submit" value="Sign in" class="btn" id="in"> <br>
		<!-- 회원가입으로 가능 링크 추가 -->
		<a href="Share_Join.jsp"><input type="button" value="회원가입" class="btn"></a>
	</form>
	
	<%
	} else {
	%>
		<!-- 로그인 된 상태  -->
		<%= session.getAttribute("UserName") %> 회원님, 로그인하셨습니다.<br>
		<a href="Share_Logout.jsp">[로그아웃]</a>
	<%
	}
	%>
	

	
</body>
</html>