<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 레이어 팝업창 띄울지 여부
String popupMode = "on";

// 쿠키를 읽어 popupMode 값 설정
Cookie[] cookies = request.getCookies();
if ( cookies != null) {
	for (Cookie c : cookies){
		String cookieName = c.getName();
		String cookieValue = c.getValue();
		// popupclose 쿠키가 존재하면
		if (cookieName.equals("PopupClose")){
			// popupmode의 값 갱신
			popupMode = cookieValue;
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 이용한 팝업 관리 ver 0.1</title>
<style>
	div#popup{
		position: absolute; top:100px; left:50px; color:yellow;
		width:270px; height:100px; background-color:gray;
	}
	div#popup>div {
		position: relative; background-color: #ffffff; top:0px;
		border:1px solid gray; padding:10px; color:black;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</script>
<script>
$(function(){
	// closeBtn을 누르면
	$('#closeBtn').click(function(){
		//popup을 숨김 처리함
		$('#popup').hide();
		// 체크 여부
		var chkVal = $("input:checkbox[id=inactiveToday]:checked").val();
		if(chkVal==1){
			// jQuery의 ajax() 함수로 비동기 요청
			$.ajax({
				url : './PopupCookie.jsp',			// popupCookie.jsp파일에
				type : 'get',						// HTTP GET 방시으로
				data : {inactiveToday : chkVal},	// inactiveToday=<chkVal 변수의 값> 데이터를
				dataType : "text",					// 응답 데이터의 타입은 일반 텍스트이며
				// 요청 성공 시 호출되는 함수
				success : function(resData) {		// 요청 성공시
					if (resData != '')				// 응답 데이터가 있다면 
						location.reload();			// 페이지를 새로고침함.
					}
				});
			}
		});
	});
</script>
</head>
<body>
	<h2>팝업 메인 페이지(ver0.1)</h2>
<%
	for( int i = 1; i<=10; i++){
		out.print("현재 팝업창은 " + popupMode + "상태입니다.<br>");
	}
	
	// popupMode 값이 on일때만 팝업창 표시
	if(popupMode.equals("on")){
%>
		
	<div id="popup">
		<h2 align="center">공지사항 팝업입니다.</h2>
		<div align="right"><form name="popFrm">
			<input type="checkbox" id="inactiveToday" value="1"/>
			하루 동안 열지 않음
			<input type="button" value = "닫기" id = "closeBtn"/>
		</form></div>
	</div>
		
		

<%
	}
%>
</body>
</html>