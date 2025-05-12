package mvcboard;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// 애너테이션으로 요청명과 서블릿을 매핑함
@WebServlet("/mvcboard/view.do")
public class ViewController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        // 게시물 불러오기
    	// DAO 객체 생성
        MVCBoardDAO dao = new MVCBoardDAO(); 
        // 게시물 일련번호를 매개변수로 받음
        String idx = req.getParameter("idx");
        dao.updateVisitCount(idx);  // 조회수 1 증가
        // 게시물 내용을 가져옴
        MVCBoardDTO dto = dao.selectView(idx);
        dao.close();

        // 줄바꿈 처리
        dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
        
        // 첨부파일이 있는 경우 파일의 확장자를 추출
        // 첨부 파일이 이미지라면 img태그로 상세보기 화면을 보여줌
        String ext = null, fileName = dto.getSfile();
        if(fileName!=null) {
        	ext = fileName.substring(fileName.lastIndexOf(".")+1);
        }
        // String 타입 배열에 이미지 확장자들을 저장한 후 
        String[] mimeStr = {"png","jpg","gif"};
        // ArraysasList를 이용해 list 컬렉션으로 반환
        List<String>mimeList = Arrays.asList(mimeStr);
        boolean isImage = false;
        // conatins 메서드로 컬렉션에 포함된 확장자인지 확인하여 포함되어 있다면 isImage 변수의 값을 true로 변경
        if(mimeList.contains(ext)) {
        	isImage = true;
        }

        // 게시물(dto) 저장 후 뷰로 포워드
        // DTO 객체와 isImage를 request 영역에 저장
        req.setAttribute("dto", dto);
        req.setAttribute("isImage", isImage);
        // 뷰로 포워드
        req.getRequestDispatcher("/JSP_CH14/View.jsp").forward(req, resp);
    }
}