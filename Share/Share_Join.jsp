<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.input {
	border-radius: 100px;
	background-color: lightgray;
	border: 0px;
	height: 20px;
	padding: 5px;
	margin: 5px;
}

.btn {
	border-radius: 100px;
	border: 0px;
	width: 180px;
	height: 30px;
	margin: 5px;
	text-align: center;
	background-color : lightblue;
}
select {
	border-radius : 100px;
	width: 180px;
	height: 30px;
}
</style>
</head>
<body>
<jsp:include page="../common/Share_Link.jsp"/>
	<h2>회원가입</h2>
	<form action="Share_JoinProcess.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
			</tr>
			<tr>
				<td><input type="password" class="input" name="pass"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
			</tr>
			<tr>
				<td><input type="password" class="input" name="passcheck">
				</td>
			</tr>
			<tr>
				<td>이름</td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="name"></td>
			</tr>
			<tr>
				<td>생년월일</td>
			</tr>
			<tr>
				<td><input type="date" class="input" name="birth"></td>
			</tr>
			<tr>
				<td>이메일</td>
			</tr>
			<tr>
				<td><input type="text" class="input" name="email"> @ <select
					name="email_domain" >
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="daum.net">daum.net</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="가입하기" class="btn"></td>
			</tr>

		</table>
	</form>
</body>
</html>