<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "common.JDBConnect" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2> 회원 추가 테스트(executeUpdate() 사용)</h2>
	<%
	// DB에 연결
	JDBConnect jdbc = new JDBConnect();
	
	// 테스트용 입력값 준비
	String id = request.getParameter("id");
	String pass = request.getParameter("password");
	String name = request.getParameter("name");
	
	// 쿼리문 생성
	String sql = "INSERT INTO member VALUES(?,?,?,sysdate())";
	PreparedStatement psmt = jdbc.con.prepareStatement(sql);
	psmt.setString(1,id);				// 첫번째 물음표에 id 값을 대입
	psmt.setString(2,pass);				// 첫번째 물음표에 pass 값을 대입
	psmt.setString(3,name);				// 첫번째 물음표에 name 값을 대입
	
	// 쿼리 수행
	int inResult = psmt.executeUpdate();
	out.println(inResult + "행이 입력되었습니다.");
	
	// 연결 닫기
	jdbc.close();
	%>
</body>
</html>