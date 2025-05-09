<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 첨부형 게시판</title>
<!-- a태그 밑줄 제거 -->
<style>a{text-decoration:none;}</style>
</head>
<body>
    <h2>파일 첨부형 게시판 - 목록 보기(List)</h2>

    <!-- 검색 폼 -->
    <!-- 여기서 입력된 검색어는 listcontroller 서블릿으로 전송된 후 mvcboardDAO 클래스의 selectcount와 
    	 selectlistpage메서드의 인수로 전달됨 -->
    <form method="get">  
    <table border="1" width="90%">
    <tr>
        <td align="center">
            <select name="searchField">
                <option value="title">제목</option>
                <option value="content">내용</option>
            </select>
            <input type="text" name="searchWord" />
            <input type="submit" value="검색하기" />
        </td>
    </tr>
    </table>
    </form>

    <!-- 목록 테이블 -->
    <table border="1" width="90%">
        <tr>
            <th width="10%">번호</th>
            <th width="*">제목</th>
            <th width="15%">작성자</th>
            <th width="10%">조회수</th>
            <th width="15%">작성일</th>
            <th width="8%">첨부</th>
        </tr>
<c:choose>    
	<%-- 게시물이 없을 때 --%>
	<%-- EL의 empty 연산자로 출력할 게시물이 없는지 확인함  --%>
    <c:when test="${ empty boardLists }">  
        <tr>
            <td colspan="6" align="center">
                등록된 게시물이 없습니다^^*
            </td>
        </tr>
    </c:when>
    <%-- 게시물이 있을 때 --%>
    <%-- 출력할 게시물이 있다면 c:foreach 태그를 통해 반복 출력함 --%>
    <c:otherwise>  
        <c:forEach items="${ boardLists }" var="row" varStatus="loop">    
        <tr align="center">
            <td>  <%-- 번호 --%>
            	  <%-- varstatus 속성을 이용해서 목록에 출력할 가상번호를 계산함 --%>
            	  <%-- ${ 전체 게시물 수 - (((현재 페이지 번호 - 1 ) * 페이지 사이즈) + varStatus의 index값) } --%>
                ${ map.totalCount - (((map.pageNum-1) * map.pageSize) + loop.index)}   
            </td>
            <td align="left">  <%-- 제목(링크) --%>
            				   <%-- 상세보기 페이지로 바로가기 링크, 게시물의 일련번호를 매개변수로 사용 --%>
                <a href="../mvcboard/view.do?idx=${ row.idx }">${ row.title }</a> 
            </td> 
            <td>${ row.name }</td>  <%-- 작성자 --%>
            <td>${ row.visitcount }</td>  <%-- 조회수 --%>
            <td>${ row.postdate }</td>  <%-- 작성일 --%>
            <td>  <%-- 첨부 파일 --%>
            <c:if test="${ not empty row.ofile }">
            	<%-- 첨부된 파일을 다운로드하기 위한 링크, 원본 파일명과 저장된 파일명 및 일련번호를 매개 변수로 사용함 --%>
                <a href="../mvcboard/download.do?ofile=${ row.ofile }&sfile=${ row.sfile }&idx=${ row.idx }">[Down]</a>
            </c:if>
            </td>
        </tr>
        </c:forEach>        
    </c:otherwise>    
</c:choose>
    </table>

    <!-- 하단 메뉴(바로가기, 글쓰기) -->
    <table border="1" width="90%">
        <tr align="center">
            <td>
                ${ map.pagingImg }
            </td>
            <td width="100"><button type="button"
                onclick="location.href='../mvcboard/write.do';">글쓰기</button></td>
        </tr>
    </table>
</body>
</html>