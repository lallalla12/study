<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>상세 내용 보기</h1>
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${board.title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${board.content}</td>
		</tr>
		<tr>
			<td colspan="2"><a href="/board/modify?bno=${board.bno }">[수정]</a>
				<a href="/board/remove?bno=${board.bno }">[삭제]</a></td>
		</tr>
	</table>

	<div>
		<input type="hidden" id="bno" name="bno" value="${board.bno }">
		<input type="text" id="replyer" name="replyer" value="현정정">
	</div>
	<div>
		<textarea id="reply" name="reply" cols="40" rows="10"></textarea>
	</div>
	<input type="button" id="RegisterBtn" value="등록">
	<div>
		<ul id="replyView">

		</ul>


	</div>
	<script src="/resources/js/reply.js"></script>
	<script>
	function showList() {
		list(
				{
					bno : $("#bno").val()
				},
				function(data) {
					let str = ""
					for (let i = 0; i < data.length; i++) {
						str += "<li class='left clearfix' data-rno='"+data[i].rno+"'>";
						str += " <div><div class='header'><strong class='primary-font'>["
						str += data[i].rno + "] "
								+ data[i].replyer
								+ "</strong>";
						str += "		</div><textarea readonly>"
								+ data[i].reply
								+ "</textarea>";
						str += "<button class='ModBtn' data-rno='" +data[i].rno+"'>수정</button>";
						str += "<button class='RemoveBtn' data-rno='" +data[i].rno+"'>삭제</button>";
						str += "</div></li>";
					}

					$("#replyView").html(str)

				})
	}
		$(document)
				.ready(
						function() {
							let bno = 0;
							let reply = "";
							let replyer = "";

							showList(); //showList함수 호출

							

							// 댓글 작성 버튼을 선택한 후 클릭 이벤트 연결
							$("#RegisterBtn").on("click", function() {

								let replyvo = {
									// reply값 가져오기
									reply : $("#reply").val(),
									// replyer값 가져오기
									replyer : $("#replyer").val(),
									// bno값 가져오기
									bno : $("#bno").val()
								}

								console.log(replyvo);
								add(replyvo, function() {
									showList();
								});

							});
							// 댓글 수정버튼을 선택한 후 클릭이벤트 연결
							$("#replyView").on("click", ".ModBtn", function() {
								let $btn = $(this);
								// textarea 태그 선택
								let $textarea = $btn.siblings("textarea");
								// 댓글 번호
								let rno = $(this).data("rno");

								// 수정버튼일때
								if ($btn.text() == "수정") {
									// 수정버튼
									$textarea.removeAttr("readonly").focus();
									$btn.text("저장");
									// 저장버튼일때
								} else {
									// 댓글 내용
									let updateReply = $textarea.val();
									// 댓글 번호
									// 댓글 수정을 한 후 
									update({
										rno : rno,
										reply : updateReply
									},
									// 후속 처리
									function() {
										alert("aaa")
										// 저장버튼 -> 수정버튼
										$btn.text("수정")
										// textarea를 읽기전용
										$textarea.attr("readonly", true)
										showList();
									})

								}

							})// 댓글 수정버튼을 선택한 후 클릭이벤트 연결 끝나는 부분

							// 댓글삭제 버튼을 선택한 후 클릭이벤트 연결
							$("#replyView").on("click", ".RemoveBtn",
									function() {
										// 댓글 번호
										let $btn = $(this);
										let rno = $(this).data("rno");

										console.log(rno)

										remove({
											rno : rno
										}, function(data) {
											showList();
											// 삭제 후 처리
										})

									})// 댓글삭제 버튼을 선택한 후 클릭이벤트 연결 끝나는 부분
						});
	</script>
</body>
</html>