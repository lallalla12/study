<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>게시판 목록</title>
</head>
<body>
  <h1>게시판 목록 리스트</h1>
  
  <table border="1">
    <tr>
      <td>No.</td>
      <td>제목</td>
      <td>작성자</td>
      <td>작성일자</td>
    </tr>
    <c:forEach items="${list}" var="board">
      <tr>
        <td>${board.bno}</td>
        <!-- 사용자가 클릭한 bno값을 넘김 -->
        <td><a href="/board/get?bno=${board.bno}">${board.title}</a></td>
        <td>${board.writer}</td>
        <!-- fmt:formatDate : 시간빼고 날짜만 출력 -->
        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" /></td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
