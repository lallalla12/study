<%@ page import = "java.util.List" %>
<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "model1.board.BoardDAO" %>
<%@ page import = "model1.board.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// DAO를 생성해 DB에 연결
BoardDAO dao = new BoardDAO(application);

// 사용자가 입력한 검색 조건을 MAP에 저장
Map<String, Object> param = new HashMap<String, Object>();
String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");
if(searchWord != null){
	param.put("searchField", searchField);
	param.put("searchWord", searchWord);
}

// 게시물 수 확인
int totalCount = dao.selectCount(param);
// 게시물 목록 받기
List<BoardDTO> boardLists = dao.selectList(param);
// DB연결 닫기
dao.close();
%>

<style>
	#toptable {
		background-color : rgb(223, 244, 252);
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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/Share_Link.jsp"/>
	
	<h2> 게시판 </h2>
	
	<!--  게시물 목록 테이블(표) -->
	<table width="90%" >
	<!-- 테이블 제목 행 -->
	
	<tr id="toptable">
		<th width="10%"> 번호 </th>
		<th width="60%"> 제목 </th>
		<th width="15%"> 작성자 </th>
		<th width="15%"> 작성일 </th>
	</tr>
	
	<!-- 목록 출력 -->
	<%
	if (boardLists.isEmpty()){
	%>
		<tr>
			<td colspan="4" align="center">
				등록된 게시물이 없네요. 글쓰기를 눌러 글을 작성해보세요 ^^!
			</td>
		</tr>
	<%
	} else {
		int virtualNum = totalCount;
		for (BoardDTO dto : boardLists) {
	%>
			<tr align="center">
				<td><%= virtualNum-- %></td>
				<td align="center">
					<a href="Share_View.jsp?num=<%= dto.getNum() %>">
						<%= dto.getTitle() %>
					</a>
				</td>
				<td><%= dto.getId() %></td>
				<td><%= dto.getPostdate() %></td>
			</tr>
	<%
		}
	}
	%>
</table>

	<!--  목록 하단의 [글쓰기] 버튼 -->
	<table width="90%" id="bottomtable">
		<tr align = "left">
			<td><button type = "button" onclick = "location.href='Share_Write.jsp';">글쓰기
				</button></td>
		</tr>
	
	</table>
</body>
</html>