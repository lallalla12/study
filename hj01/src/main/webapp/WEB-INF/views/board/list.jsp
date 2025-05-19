<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<style>
.pagination {
	list-style: none;
	display: flex;
}

.pagination li {
	margin: 0 5px;
}
</style>
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
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${board.regdate}" /></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><a href="/board/write">글쓰기</a></td>
		</tr>
	</table>
	<form action="/board/list" method="get">
		<input type="hidden" value="${pageMaker.cri.pageNum}" name="pageNum">
		<input type="hidden" value="${pageMaker.cri.amount}" name="amount">
		<select name="type">
		
			<option value="T">제목</option>
			<option value="C">내용</option>
			<option value="W">작성자</option>
			<option value="TC">제목 or 내용</option>
			<option value="TW">제목 or 작성자</option>
			<option value="TCW">제목 or 내용 or 작성자</option>
		</select> <input type="text" name="keyword"> <input type="submit"
			value="검색">
	</form>
	<div class='pull-right'>
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li class="paginate_button previous"><a
					href="/board/list?pageNum=${pageMaker.startPage - 1}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">Previous</a></li>
			</c:if>

			<c:forEach var="num" begin="${pageMaker.startPage}"
				end="${pageMaker.endPage}">
				<li
					class="paginate_button ${pageMaker.cri.pageNum == num ? 'active' : ''}">
					<a href="/board/list?pageNum=${num}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">${num}</a>
				</li>
			</c:forEach>

			<c:if test="${pageMaker.next}">
				<li class="paginate_button next"><a
					href="/board/list?pageNum=${pageMaker.endPage + 1}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">Next</a></li>
			</c:if>
		</ul>
	</div>

</body>
</html>
