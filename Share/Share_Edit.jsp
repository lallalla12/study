<%@ page import = "model1.board.BoardDAO" %>
<%@ page import = "model1.board.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./Share_IsLoggedIn.jsp" %>
<%
// 일련번호 받기
String num = request.getParameter("num");
// DAO 생성
BoardDAO dao = new BoardDAO(application);
// 게시물 가져오기
BoardDTO dto = dao.selectView(num);
// 로그인 ID 얻기
String sessionId = session.getAttribute("UserId").toString();
if (!sessionId.equals(dto.getId())) {
    // 본인인지 아닌지 확인
    JSFunction.alertBack("작성자 본인만 수정할 수 있습니다", out);
    return;
}
// DB 연결 해제
dao.close();
%>
<style>
    .input{
        border-color : rgb(63, 138, 165);
        width:90%;
        height:30px;
        border-radius : 10px;
    }
    button{
        background-color:lightblue;
        width:100px;
        height:50px;
        border-radius : 10px;
        border-color : rgb(63, 138, 165);
        box-shadow: none;
    }
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script>
function deletePost(){
	var confirmed = confirm("정말로 삭제할거에요 ㅜㅜ..?");
	if (confirmed) {
		var form = document.writeFrm;
		form.method = "post"; 				// get방식을 post로 바꿈 (전송방식)
		form.action = "Share_DeleteProcess.jsp";	// 경로 설정
		form.submit();						// 폼값 전송
	}
}
</script>
</head>
<body>
    <jsp:include page="../common/Share_Link.jsp"/>
    <script type="text/javascript">
        // 폼 내용 검증
        function validateForm(form){
            // form에 제목과 내용이 입력되었는지 확인
            if (form.title.value == ""){
                alert("제목을 입력하세요.");
                form.title.focus();
                return false;
            }
            // 비어있다면 alert창을 띄우고 포커스를 이동 시킨 후 false를 반환.
            if (form.content.value == ""){
                alert("내용을 입력하세요.");
                form.content.focus();
                return false;
            }
        }
    </script>

    <h2>글쓰기</h2>
    <form name="writeFrm" method="post" action="Share_EditProcess.jsp"
        onsubmit="return validateForm(this);">
        <input type="hidden" name="num" value="<%= dto.getNum() %>"/>
        <table width="90%">
            <tr>
                <td>
                    Title<br>
                    <input type="text" name="title" placeholder="제목을 입력하세요." class="input"
                        value="<%= dto.getTitle() %>" />
                </td>
            </tr>
            <tr>
                <td>Comment
                    <input type="text" placeholder="내용을 입력하세요." name="content" style="width: 90%; height:200px;" 
                    	class="input" value="<%= dto.getContent() %>"> 
                     
                </td>
            </tr>
            <tr>
                <td colspan="2" align="left">
                    <button type="submit">등록</button>
                    <button type = "button" onclick = "deletePost();">삭제하기</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
