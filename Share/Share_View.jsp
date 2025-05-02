<%@ page import = "model1.board.BoardDAO" %>
<%@ page import = "model1.board.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 일련번호 받기
String num = request.getParameter("num");
// DAO 생성한 후 앞 절에서 작성한 두 메서드를 호출
BoardDAO dao = new BoardDAO(application);
// 게시물 가져오기
BoardDTO dto = dao.selectView(num);
// DB 연결 해제
dao.close();
%>
<style>
	#notice{
		background-color:rgb(230, 246, 252);
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
<title>회원제 게시판</title>
</head>
<body>
<jsp:include page="../common/Share_Link.jsp"/>
<h2> 상세 보기</h2>
<form name = "writeFrm">
	<input type="hidden" name="num" value = "<%= num %>" />
	<table width="90%" id="notice" border = "1">
		<tr>
			<td>번호</td>
			<td><%= dto.getNum() %></td>
			<td rowspan="2">작성자</td>
			<td rowspan="2"><%= dto.getName() %></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><%= dto.getPostdate() %></td>
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
					onclick = "location.href='Share_Edit.jsp?num=<%= dto.getNum() %>';">
						수정하기</button>
				<%
				}
				%>
				<button type = "button" onclick = "location.href='Share_List.jsp';">
					목록보기
				</button>
			</td>
		</tr>

	</table>

</form>
</body>
</html>