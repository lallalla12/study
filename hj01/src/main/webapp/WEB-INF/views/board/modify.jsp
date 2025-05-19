<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정 화면으로 이동...</h1>
	<form action = "/board/modify" method="post">
		<table border="1">
			<tr>
				<td>제목</td>
				<td>
					<input type="hidden" name="bno" value="${board.bno}">
					<input type="text" name="title" value="${board.title}">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content">"${board.content}"</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="[수정]">
			</tr>
		</table>
	</form>
</body>
</html>