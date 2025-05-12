package mvcboard;

import java.io.IOException;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.JSFunction;

@WebServlet("/mvcboard/edit.do")
// 애너테이션으로 파일 업로드를 위한 multipart 설정을 해줌
@MultipartConfig(
		// 1MB
		maxFileSize = 1024 * 1024 * 1, 
		// 10MB
		maxRequestSize = 1024 * 1024 * 10 
)

	
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		// 수정할 게시물의 일련번호를 받아서
		String idx = req.getParameter("idx");
		MVCBoardDAO dao = new MVCBoardDAO();
		// 기존 게시물 내용을 담은 DTO 객체의
		MVCBoardDTO dto = dao.selectView(idx);
		// request 영역에 저장한 다음
		req.setAttribute("dto", dto);
		// Edit.jsp로 포워드함
		req.getRequestDispatcher("/JSP_CH14/Edit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		// 1. 파일 업로드 처리 =============================
		// 파일이 업로드될 디렉터리의 물리적 경로를 얻어온 후 request내장 객체와 함께 인수로 넣어
		String saveDirectory = req.getServletContext().getRealPath("/Uploads");
		
		// 파일을 업로드함. 업로드 중 예외가 발생하면 경고창을 띄우고 글쓰기 페이지로 이동
		String originalFileName = "";
		try {
			originalFileName = FileUtil.uploadFile(req, saveDirectory);
		}
		catch (Exception e) {
			JSFunction.alertBack(resp, "파일 업로드 오류입니다.");
			return;
		}
		
		// 2. 파일 업로드 외 처리 =============================
		// 수정 내용을 매개변수에서 얻어옴
		String idx = req.getParameter("idx");
		String prevOfile = req.getParameter("prevOfile");
		String prevSfile = req.getParameter("prevSfile");
		
		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		// 비밀번호는 session에서 가져옴
		HttpSession session = req.getSession();
		String pass = (String)session.getAttribute("pass");
		
		// DTO에 저장
		MVCBoardDTO dto = new MVCBoardDTO();
		dto.setIdx(idx);
		dto.setName(name);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPass(pass);
		
		// 원본 파일명과 저장된 파일 이름 설정
		if (originalFileName != "") {
			String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
			
			// 원래 파일 이름
			dto.setOfile(originalFileName);
			// 서버에 저장된 파일 이름
			dto.setSfile(savedFileName);
			
			// 기존 파일 삭제
			FileUtil.deleteFile(req, "/Uploads", prevSfile);
		}
		else {
			//  첨부 파일이 없으면 기존 이름 유지
			dto.setOfile(prevOfile);
			dto.setSfile(prevSfile);
		}
		
		// DB에 수정 내용 반영
		MVCBoardDAO dao = new MVCBoardDAO();
		int result = dao.updatePost(dto);
		dao.close();
		
		// 성공 or 실패?
		if (result == 1) {
			// 수정 성공
			session.removeAttribute("pass");
			resp.sendRedirect("../mvcboard/view.do?idx=" + idx);
		}
		// 수정 실패
		else {
			JSFunction.alertLocation(resp, "비밀번호 검증을 다시 진행해주세요.", "../mvcboard/view.do?idx=" + idx);
		}
		
		
		
		
	}
}
