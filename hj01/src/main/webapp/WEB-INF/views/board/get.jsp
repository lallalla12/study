<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�� ���� ����</h1>
	<table>
		<tr>
			<td>����</td>
			<td>${board.tile}</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${board.content}</td>
		</tr>
	</table>
	${board}
</body>
</html>