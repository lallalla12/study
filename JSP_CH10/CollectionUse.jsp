<%@ page import = "java.util.HashMap" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "common.Person" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어(EL)-컬렉션</title>
</head>
<body>
	<h2>List 컬렉션</h2>
<%
List<Object> aList = new ArrayList<Object>();
aList.add("청해진");
aList.add(new Person("장보고", 28));
pageContext.setAttribute("Ocean", aList);
%>
<ul>
	<!-- List는 배열처럼 인덱스로 접근할 수 있음 -->
	<li>0번째 요소 : ${ Ocean[0] }</li>
	<li>1번째 요소 : ${ Ocean[1].name }, ${ Ocean[1].age }</li>
	<li>2번째 요소 : ${ Ocean[2] }</li> <!-- 출력되지 않음 -->
</ul>
<h2>Map 컬렉션</h2>
<%
Map<String, String> map = new HashMap<String, String>();
map.put("한글","훈민정음");
map.put("Eng", "English");
pageContext.setAttribute("King", map);
%>
<ul>
	<!-- Map은 List와 달리 키를 입력해 값을 가져옴 키가 영문이면 3가지 방식을 모두 이용할 수 있음 -->
	<li>영문 Key : ${ King["Eng"] }, ${King['Eng'] }, ${ King.Eng }</li>
	<!-- 한글이면 .(점)은 사용할 수 없음
		 EL코드를 주석처리하려면 앞에 \(역슬래시)를 붙임 -->
	<li>영문 Key : ${ King["한글"] }, ${King['한글'] }, \${ King.한글 }</li>
</ul>


</body>
</html>