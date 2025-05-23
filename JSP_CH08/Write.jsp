<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 로그인 확인 -->
<%@ include file="./IsLoggedIn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>
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
</head>
<body>
	<jsp:include page = "../common/Link.jsp"/>
	<h2>회원제 게시판 - 글쓰기(write)</h2>
	<form name="writeFrm" method="post" action="WriteProcess.jsp"
		onsubmit="return validateForm(this);">
	<table border="1" width="90%">
		<tr>
			<td> 제목 </td>
			<td>
				<input type="text" name="title" style="width:90%;"/>
			</td>
		</tr>
		<tr>
			<td> 내용 </td>
			<td>
				<textarea name = "content" style = "width: 90%; height:100px;">
				</textarea>
			</td>
		</tr>
		<tr>
			<td colspan = "2" align = "center">
				<button type = "submit"> 작성 완료 </button>
				<button type = "reset"> 다시 입력 </button>
				<button type = "button" onclick = "location.href='List.jsp';">
					목록 보기</button>
			</td>
		</tr>
	</table>
</body>
</html>