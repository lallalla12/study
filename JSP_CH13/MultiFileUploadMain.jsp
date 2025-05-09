<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>FileUpload</title>
</head>
<script>
	// 작성폼의 입력값을 검증하기 위한 자바스크립트
	// 작성자 이름, 제목, 첨부파일이 입력되었는지 확인하여, 만약 입력되어 있지 않으면 경고창을 띄우고 해당 입력란으로 포커스를 이동, 
	// 실패 시, false반환
	function validateForm(form) {
		if (form.title.value == "") {
			alert("제목을 입력하세요.");
			form.title.focus();
			return false;
		}
		if (form.attachedFile.value == "") {
			alert("첨부파일은 필수 입력입니다.");
			return false;
		}
	}
</script>
<body>
	<h3>멀티 파일 업로드(multiple 속성 추가)</h3>
	<span style="color: red;">${errorMessage }</span>
	<form name="fileForm" method="post" enctype="multipart/form-data"
		action="MultipleUploadProcess.do" onsubmit="return validateForm(this);">
		제목 : <input type="text" name="title" /><br /> 
		카테고리(선택사항) : <input type="checkbox" name="cate" value="사진" checked />
		사진 <input type="checkbox" name="cate" value="과제" />
		과제 <input type="checkbox"name="cate" value="워드" />
		워드 <input type="checkbox" name="cate" value="음원" />
		음원 <br /> 
		<!-- multiple속성은 ctrl키를 누르거나 마우스를 드래그하여 여러 파일을 선택할 수 있게 해줌  -->
		첨부파일 : <input type="file" name="ofile" multiple /> <br /> 
		<input type="submit" value="전송하기" />
	</form>
</body>
</html>