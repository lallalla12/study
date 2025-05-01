<%@ page import = "model1.board.BoardDAO" %>
<%@ page import = "model1.board.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "./IsLoggedIn.jsp" %>
<%
// 폼값 팓기 
String title = request.getParameter("title");
String content = request.getParameter("content");

// 폼값을 DTO 객체에 저장
BoardDTO dto = new BoardDTO();
dto.setTitle(title);
dto.setContent(content);
// board 테이블의 id 컬럼은 member 테이블의 id 컬럼과 외래키로 설정되어있어, id가 빈값이면 제약조건 위배로 오류가 발생하기에 dto에 담음.
dto.setId(session.getAttribute("UserId").toString());

// DAO 객체를 통해 DB에 DTO 저장
// dto 객체에 담은 것을 insertwrite를 호출해 db에 저장
BoardDAO dao = new BoardDAO(application);
int iResult = dao.insertWrite(dto);
dao.close();


if (iResult == 1) {
	// 성공하면 목록 페이지로 이동
	response.sendRedirect("List.jsp");
} else{
	// 실패하면 alert창을 띄운 후 이전페이지(글쓰기 페이지)로 이동
	JSFunction.alertBack("글쓰기에 실패하였습니다.", out);
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