<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	html, body {
	height: 100%;
	margin: 0;
	}
	
	body{
		width:100%;
		height:100%;
		background-color : lightblue;
	}

	#list {

	height: auto;
	display : flex;
	justify-content :center;
	align-items: center;
	
	}
	
	#content {
	background-color : white;
	height: 600px;
	width: 100%;
	display:flex;
	justify-content :center;
	align-items: center;
	}
	

	
	ul li{
	float:left;
	list-style: none;
	padding : 5px;
	
	}
	
	ul li a {
	text-decoration :none;
	color : white;
	}
	
	ul li:last-child {
	border-right: none; 
	}
	
	#footer {
	height: 50px;
	
	}
	
	
</style>
</head>
<body>
	<div id=list>
		<ul>
			<li><a href="Include_login.jsp">로그인 |</a></li>
			<li><a href="Include_join.jsp">회원가입 |</a></li>
			<li><a href="Include_write.jsp">게시판</a></li>
		</ul>
				
	</div>
	
	<div id=footer>
	
	</div>
	
	

</body>
</html>