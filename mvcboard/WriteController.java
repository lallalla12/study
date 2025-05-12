package mvcboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



import fileupload.FileUtil;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JSFunction;

public class WriteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/JSP_CH14/Write.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 1. 파일 업로드 처리 =============================
        // 업로드 디렉터리의 물리적 경로 확인
        String saveDirectory = req.getServletContext().getRealPath("/Uploads");


        // 파일 업로드
        // 13장에서 만든 fileutil.uploadfile메서드 호출
        String originalFileName = "";
        try {
        	originalFileName = FileUtil.uploadFile(req, saveDirectory);
        }
        catch (Exception e) {
        	// 파일 업로드 실패하면 경고창 띄우고 작성 페이지로 돌아감
        	JSFunction.alertLocation(resp, " 파일 업로드 오류입니다.", "../mvcboard/write.do");
            return;
        }

        // 2. 파일 업로드 외 처리 =============================
        // 폼값을 DTO에 저장
        // 파일 업로드에 성공했다면 파일을 제외한 나머지 폼값을 DTO에 저장
        MVCBoardDTO dto = new MVCBoardDTO(); 
        dto.setName(req.getParameter("name"));
        dto.setTitle(req.getParameter("title"));
        dto.setContent(req.getParameter("content"));
        dto.setPass(req.getParameter("pass"));

        // 원본 파일명과 저장된 파일 이름 설정
        // 업로드된 파일이 있는지 확인
        if (originalFileName != "") {
            // 첨부 파일이 있을 경우 파일명 변경
        	// 원본 파일명과 변경된 파일명을 따로 기록하기 위해 DTO에 저장
        	// 만약 파일 첨부하지 않았으면 이부분은 실행되지 않음
        	String savedFileName = FileUtil.renameFile(saveDirectory,  originalFileName);

            
            dto.setOfile(originalFileName);  // 원래 파일 이름
            dto.setSfile(savedFileName);  // 서버에 저장된 파일 이름
            
        }

        // DAO를 통해 DB에 게시 내용 저장
        MVCBoardDAO dao = new MVCBoardDAO();
        int result = dao.insertWrite(dto);
        dao.close();

        // 성공 or 실패?
        // 모든 작업이 오류 없이 완료되었다면 목록으로 이동
        if (result == 1) {  // 글쓰기 성공
            resp.sendRedirect("../mvcboard/list.do");
        }
        else {  // 글쓰기 실패했으면 경고창을 띄우고 글쓰기 페이지로 돌아감
            JSFunction.alertLocation(resp, "글쓰기에 실패했습니다.", "../mvcboard/write.do");
        }
    }}