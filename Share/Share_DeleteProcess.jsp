<%@ page import = "model1.board.BoardDAO" %>
<%@ page import = "model1.board.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./Share_IsLoggedIn.jsp" %>
<% 
// 일련번호 얻기
String num = request.getParameter("num");
// DTO 객체 생성
BoardDTO dto = new BoardDTO();
// DAO 객체 생성
BoardDAO dao = new BoardDAO(application);
// 주어진 일련번호에 해당하는 기존 게시물 얻기
dto = dao.selectView(num);

// 로그인된 사용자 ID 얻기
String sessionId = session.getAttribute("UserId").toString();

int delResult = 0;
System.out.println(dto.getId());
// 작성자가 본인인지 확인
if (sessionId.equals(dto.getId())){
	// 작성자가 본인이라면
	dto.setName(num);
	delResult = dao.deletePost(dto);	// 삭제
	dao.close();
	
	if (delResult == 1){
		// 성공 시 목록 페이지로 이동
		JSFunction.alertLocation("성공적으로 삭제되었어요 /^0^/.", "Share_List.jsp", out);
	}else {
		// 실패 시 이전 페이지로 이동
		JSFunction.alertBack("삭제가 안되는데용 ㅠ_ㅜ...", out);
	}
}
else {
	// 작성자가 본인이 아니면 이전 페이지로 이동
	JSFunction.alertBack("본인이 아닌데 왜 삭제하려고하세욧!", out);
	
	return;
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