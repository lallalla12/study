<%@ page import = "model1.board.BoardDAO" %>
<%@ page import = "model1.board.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 로그인 상태 확인 include -->
<%@ include file="./IsLoggedIn.jsp" %>
<%
// 수정 내용 얻기
String num = request.getParameter("num");
String title = request.getParameter("title");
String content = request.getParameter("content");

// DTO에 저장
BoardDTO dto = new BoardDTO();
dto.setNum(num);
dto.setTitle(title);
dto.setContent(content);

// DB에 반영
BoardDAO dao = new BoardDAO(application);
// 문제없이 수정했다면 1이 반환됨.
int affected = dao.updateEdit(dto);
dao.close();

if (affected == 1){
	// 성공 시 상세보기 페이지로 이동 (view는 num값을 받아야하기에 ?를 써야함 list는 받을 값이 없기때문에 사용x)
	response.sendRedirect("View.jsp?num=" + dto.getNum());
}
else{
	// 실패 시 이전 페이지로 이동
	JSFunction.alertBack("수정하기에 실패하였습니다", out);
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