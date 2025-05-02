<%@ page import = "model1.board.BoardDAO" %>
<%@ page import = "model1.board.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  로그인한 상태인지 확인하기위해 인클루드 -->
<%@ include file="./IsLoggedIn.jsp" %>
<%
// 일련번호 받기
String num = request.getParameter("num");
// DAO 생성
BoardDAO dao = new BoardDAO(application);
// 게시물 가져오기
BoardDTO dto = dao.selectView(num);
// 로그인 ID 얻기
String sessionId = session.getAttribute("UserId").toString();
if (!sessionId.equals(dto.getId())) {
	// 본인인지 아닌지 확인
	JSFunction.alertBack("작성자 본인만 수정할 수 있습니다", out);
	return;
}
// DB 연결 해제
dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>
<script type = "text/javascript">
	function validateForm(form){
	// 폼 내용 검증
if (form.title.value == ""){
	alert("제목을 입력하세요.");
	form.title.focus();
	return false;
	}
	if (form.content.value ==""){
		alert("내용을 입력하세요.");
		form.content.focus();
		return false;
		}
	}
</script>
</head>
<body>
	<jsp:include page = "../common/Link.jsp"/>
	<h2>회원제 게시판 - 수정하기(Edit)</h2>
	<form name="writeFrm" method="post" action="EditProcess.jsp"
		onsubmit="return validateForm(this);">
	<!-- hidden : 선택된 게시물의 일련번호를 EditProcess.jsp에 전달하는 역할 -->
	<input type = "hidden" name="num" value="<%= dto.getNum() %>" />
	<table border="1" width="90%">
		<tr>
			<td> 제목 </td>
			<td>
				<input type="text" name="title" style="width:90%;"
					value = "<%= dto.getTitle() %>"/>
					<!-- 기존 게시물 제목 -->
			</td>
		</tr>
		<tr>
			<td> 내용 </td>
			<td>
				<textarea name = "content" style = "width: 90%; height:100px;">
				<%= dto.getContent() %>
				</textarea>
				<!-- 기존 게시물 내용 -->
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