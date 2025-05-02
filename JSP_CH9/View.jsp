<%@ page import = "model1.board.BoardDAO" %>
<%@ page import = "model1.board.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 일련번호 받기
String num = request.getParameter("num");
// DAO 생성한 후 앞 절에서 작성한 두 메서드를 호출
BoardDAO dao = new BoardDAO(application);
// 조회수 증가
dao.updateVisitCount(num);
// 게시물 가져오기
BoardDTO dto = dao.selectView(num);
// DB 연결 해제
dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>
<script>
function deletePost(){
	var confirmed = confirm("정말로 삭제하겠습니까?");
	if (confirmed) {
		var form = document.writeFrm;
		form.method = "post"; 				// get방식을 post로 바꿈 (전송방식)
		form.action = "DeleteProcess.jsp";	// 경로 설정
		form.submit();						// 폼값 전송
	}
}
</script>
</head>
<body>
<jsp:include page="../common/Link.jsp"/>
<h2> 회원제 게시판 - 상세 보기 (View)</h2>
<form name = "writeFrm">
	<input type="hidden" name="num" value = "<%= num %>" />
	<table border = "1" width="90%">
		<tr>
			<td>번호</td>
			<td><%= dto.getNum() %></td>
			<td>작성자</td>
			<td><%= dto.getName() %></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><%= dto.getPostdate() %></td>
			<td>조회수</td>
			<td><%= dto.getVisitcount() %></td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3"><%= dto.getTitle() %></td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3" height="100">
				<%= dto.getContent().replace("\r\n", "<br>") %></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<%
							// 로그인 했는지 안했는지(session 값이 있는지 아닌지)
					if(session.getAttribute("UserId") != null	
							// 내가 쓴 글인지 (아이디값을 비교하여 확인)
						&& session.getAttribute("UserId").toString().equals(
																		dto.getId())) {
				%>
				<button type="button"
					onclick = "location.href='Edit.jsp?num=<%= dto.getNum() %>';">
						수정하기</button>
				<button type = "button" onclick = "deletePost();">삭제하기</button>
				<%
				}
				%>
				<button type = "button" onclick = "location.href='List.jsp';">
					목록보기
				</button>
			</td>
		</tr>

	</table>

</form>
</body>
</html>