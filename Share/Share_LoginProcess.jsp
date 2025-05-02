<%@ page import="Sharemembership.ShareMemberDTO"%>
<%@ page import="Sharemembership.ShareMemberDAO"%>
<%@ page import="utils.CookieManager"%>
<%@ page import="utils.JSFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 로그인 폼으로부터 받은 아이디와 패스워드
String userId = request.getParameter("user_id");
String userPwd = request.getParameter("user_pw");
String save_check = request.getParameter("save_check");

// web.xml에서 가져온 데이터베이스 연결 정보
String MySQLDriver = application.getInitParameter("MySQLDriver");
String MySQLURL = application.getInitParameter("MySQLURL");
String MySQLId = application.getInitParameter("MySQLId");
String MySQLPwd = application.getInitParameter("MySQLpwd");

// 회원 테이블 DAO를 통해 회원 정보 DTO 획득
ShareMemberDAO dao = new ShareMemberDAO(MySQLDriver, MySQLURL, MySQLId, MySQLPwd);
ShareMemberDTO memberDTO = dao.getMemberDTO(userId, userPwd);
dao.close();

// 로그인 성공 여부에 따른 처리
if (memberDTO.getId() != null) {
	// 로그인 성공
	session.setAttribute("UserId", memberDTO.getId());
	session.setAttribute("UserName", memberDTO.getName());
	// [아이디 저장하기] 체크 확인
	if (save_check != null && save_check.equals("Y")) {
		CookieManager.makeCookie(response, "loginId", userId, 86400);
	}
	response.sendRedirect("Share_LoginMain.jsp");

} else {
	//로그인 실패
	request.setAttribute("LoginErrMsg", "로그인 오류입니다.");
	request.getRequestDispatcher("Share_LoginMain.jsp").forward(request, response);
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