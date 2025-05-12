package mvcboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.BoardPage;

// HttpServlet을 상속하고
public class ListController extends HttpServlet {
    @Override
    // doGet() 메서드를 오버라이딩
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       // DAO 생성
       MVCBoardDAO dao = new MVCBoardDAO();

        // 뷰에 전달할 매개변수 저장용 맵 생성
        // 모델로 전달할 검색 매개변수 및 뷰로 전달한 페이징 관련 값을 저장하기 위해 Map컬렉션을 생성
        Map<String, Object> map = new HashMap<String, Object>();

        String searchField = req.getParameter("searchField");
        String searchWord = req.getParameter("searchWord");
        if (searchWord != null) {
            // 쿼리스트링으로 전달받은 매개변수 중 검색어가 있다면 map에 저장
            map.put("searchField", searchField);
            map.put("searchWord", searchWord);
        }
        // 데이터베이스로부터 게시물 개수를 가져옴
        int totalCount = dao.selectCount(map);

        /* 페이지 처리 start */
        // 페이징 설정 값 상수를 가져와 페이징 게시물수와 블록당 페이지 수를 구하고
        ServletContext application = getServletContext();
        int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
        int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));

        // 현재 페이지 확인
        int pageNum = 1;  // 기본값
        String pageTemp = req.getParameter("pageNum");
        if (pageTemp != null && !pageTemp.equals(""))
        	// 요청받은 페이지로 수정
            pageNum = Integer.parseInt(pageTemp); 

        // 목록에 출력할 게시물 범위 계산
        // 목록에 출력할 게시물 범위를 계산해 매개변수 컬렉션에 추가
        // 첫 게시물 번호
        int start = (pageNum - 1) * pageSize;   // 0부터 시작
        int end = pageSize;                     // 가져올 행 개수
        map.put("start", start);
        map.put("end", end);
        /* 페이지 처리 end */
        
        // 검색어와 게시물 범위를 담은 map을 건네 게시물 목록을 받음
        List<MVCBoardDTO> boardLists = dao.selectListPage(map);  
        // DB 연결 닫기
        dao.close(); 

        // 뷰에 전달할 매개변수 추가
        String pagingImg = BoardPage.pagingStr(totalCount, pageSize,
        		// 바로가기 영역 HTML 문자열
                blockPage, pageNum, "../mvcboard/list.do");  
        map.put("pagingImg", pagingImg);
        map.put("totalCount", totalCount);
        map.put("pageSize", pageSize);
        map.put("pageNum", pageNum);

        // 뷰로 전달할 데이터를 request 영역에 저장한 후 list.jsp로 포워드
        req.setAttribute("boardLists", boardLists);
        req.setAttribute("map", map);
        req.getRequestDispatcher("/JSP_CH14/List.jsp").forward(req, resp);
    }
}