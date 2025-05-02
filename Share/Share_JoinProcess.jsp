<%@ page import="Sharemembership.ShareMemberDAO" %>
<%@ page import="Sharemembership.ShareMemberDTO" %>
<%@ page import="utils.JSFunction" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	// 데이터 얻기
	String id = request.getParameter("id");				 	// 아이디
	String pass = request.getParameter("pass");			 	// 비밀번호
	String passCheck = request.getParameter("passcheck"); 	// 비밀번호 확인
	String name = request.getParameter("name");				// 이름
	String birth = request.getParameter("birth");			// 생년월일
	String email = request.getParameter("email");			// 이메일
	
	
	// 비밀번호와 비밀번호 확인이 일치하는지 확인
	if (!pass.equals(passCheck)) {
		JSFunction.alertBack("비밀번호가 일치하지 않습니다.", out);
		return;
	}

	// DB 연결 정보 가져오기
	String MySQLDriver = application.getInitParameter("MySQLDriver");
	String MySQLURL = application.getInitParameter("MySQLURL");
	String MySQLId = application.getInitParameter("MySQLId");
	String MySQLPwd = application.getInitParameter("MySQLpwd");

	ShareMemberDTO member = new ShareMemberDTO();
	member.setId(id);
	member.setPass(pass);
	member.setName(name);
	member.setBirth(birth);
	member.setEmail(email);

	ShareMemberDAO dao = new ShareMemberDAO(MySQLDriver, MySQLURL, MySQLId, MySQLPwd);
	int result = dao.insertMember(member);
	dao.close();

	if (result == 1) {
		JSFunction.alertLocation("회원가입이 성공했습니다. 로그인 화면으로 이동합니다.", "Share_LoginMain.jsp", out);
		
	} else {
		JSFunction.alertBack("회원가입에 실패햐였습니다.", out);
	}
%>
