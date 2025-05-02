<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./Share_IsLoggedIn.jsp" %>
<style>
	.input{
		border-color : rgb(63, 138, 165);
		width:90%;
		height:30px;
		border-radius : 10px;
	}
	button{
		background-color:lightblue;
		width:100px;
		height:50px;
		border-radius : 10px;
		border-color : rgb(63, 138, 165);
		box-shadow: none;
	}
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<jsp:include page="../common/Share_Link.jsp"/>
	<script type = "text/javascript">
	// 폼 내용 검증
	function validateForm(form){
	// form에 제목과 내용이 입력되었는지 확인
if (form.title.value == ""){
	alert("제목을 입력하세요.");
	form.title.focus();
	return false;
	}
	// 비어있다면 alert창을 띄우고 포커스를 이동 시킨 후 false를 반환.
	if (form.content.value == ""){
		alert("내용을 입력하세요.");
		form.content.focus();
		return false;
		}
	}
</script>

	<h2>글쓰기</h2>
	<form name="writeFrm" method="post" action="Share_WriteProcess.jsp"
		onsubmit="return validateForm(this);">
	<table width="90%">
		<tr>
			
			<td>
			Title<br>
				<input type="text" name="title"  placeholder="제목을 입력하세요." class="input"/>
			</td>
		</tr>
		<tr>
			
			<td>Comment
				<input type="text" placeholder="내용을 입력하세요." name = "content" style = "width: 90%; height:200px;" class="input" >
			</td>
		</tr>
		<tr>
			
			<td colspan = "2" align = "left">
				<button type = "submit"> 등록 </button>

			</td>
		</tr>
	</table>
	
</body>
</html>