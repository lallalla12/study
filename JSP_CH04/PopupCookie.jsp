<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 체크박스 폼값을 받음
	// 체크박스를 체크 했다면 "1"이 전달
	String chkVal = request.getParameter("inactiveToday");

if (chkVal != null && chkVal.equals("1")){
	// 이름이 popupclose 값이 off
	Cookie cookie = new Cookie ("PopupClose", "off");			// 쿠키 생성
	cookie.setPath(request.getContextPath());					// 경로 생성
	// 유지기간은 하루
	cookie.setMaxAge(60*60*24);									// 유지 기간 설정
	response.addCookie(cookie);									// 응답 객체에 추가
	out.println("쿠키 : 하루 동안 열지 않음 ");
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