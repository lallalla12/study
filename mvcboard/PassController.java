package mvcboard;

import java.io.IOException;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.JSFunction;

// 애너테이션으로 요청명과 매핑
@WebServlet("/mvcboard/pass.do")
public class PassController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		// mode 매개변수의 값을 request영역에 저장한 다음
		req.setAttribute("mode", req.getParameter("mode"));
		// pass.jsp로 포워드
		req.getRequestDispatcher("/JSP_CH14/Pass.jsp").forward(req, resp);
	}
	
	@Override
	// 비밀번호 입력폼에서 전송한 값을 받아 처리하므로 doPost()메서드에서 작성
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		// 매개변수 저장
		String idx = req.getParameter("idx");
		String mode = req.getParameter("mode");
		String pass = req.getParameter("pass");
		
		// 비밀번호 확인
		MVCBoardDAO dao = new MVCBoardDAO();
		boolean confirmed = dao.confirmPassword(pass,  idx);
		dao.close();
		
		if(confirmed) {
			// 비밀번호 일치
			if(mode.equals("edit")) {
				// 수정모드
				HttpSession session = req.getSession();
				// session영역에 비밀번호 저장한 후 
				session.setAttribute("pass", pass);
				// 수정페이지로 이동
				resp.sendRedirect("../mvcboard/edit.do?idx=" + idx);
			}
			// 삭제 모드
			else if (mode.equals("delete")) {
				dao = new MVCBoardDAO();
				// 기존 정보 보관
				MVCBoardDTO dto = dao.selectView(idx);
				// 게시물 삭제
				int result = dao.deletePost(idx);
				dao.close();
				if (result == 1) {
					// 게시물 삭제 성공 시 첨부 파일도 삭제
					String saveFileName = dto.getSfile();
					FileUtil.deleteFile(req, "/Uploads", saveFileName);
				}
				JSFunction.alertLocation(resp, "삭제되었습니다", "../mvcboard/list.do");
			}
		}
		else {
			// 비밀번호 불일치
			JSFunction.alertBack(resp, "비밀번호 검증에 실패했습니다.");
		}
	}
}
