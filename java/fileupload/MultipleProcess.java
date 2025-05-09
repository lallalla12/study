package fileupload;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 애너테이션을 통해 요청명에 대한 매핑
@WebServlet("/JSP_CH13/MultipleUploadProcess.do")
// 파일업로드를 처리하기 위한 서블릿 구성 애너테이션
// 멀티파트 요청을 처리할 수 있고 Part 객체를 사용하여 업로드된 파일의 정보를 접근할 수 있음
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 1,
		maxRequestSize = 1024 * 1024 * 10
)

public class MultipleProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 파을 크기가 1mb를 초과하면 예외 발생하므로 catch절에는 reqeust 영역에 메시지를 저장한 후 
		// FileUploadMain으로 포워드
		try {
			// 물리적 경로를 얻어옴(절대경로)
			String saveDirectory = getServletContext().getRealPath("/Uploads");
			// 유틸리티 클래스의 multipleFile메서드를 호출하여 파일을 업로드함
			// 2개 이상의 파일이므로 Arraylist<string>타입으로 반환
			ArrayList<String> ListFileName = FileUtil.mulitpleFile(req, saveDirectory);
			for(String originalFileName : ListFileName) {
				// 위에서 반환받은 컬렉션의 크기, 즉 첨부한 파일의 개수만큼 반복해서 저장된 파일명을 변경하고, 테이블에 입력
				String savedFileName = FileUtil.renameFile(saveDirectory, originalFileName);
				insertMyFile(req, originalFileName, savedFileName);
			}
			// request 내장객체와 파일명을 인수로 전달하여 데이터베이스에 데이터를 저장함
			
			resp.sendRedirect("FileList.jsp");
		}
		
		catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", "파일 업로드 오류");
			req.getRequestDispatcher("FileUploadMain.jsp").forward(req, resp);
		}
	}
	
	// 매개변수로 정의된 request 내장 객체를 통해 서버로 전송된 폼값을 받을 수 있음, 원본파일명과 변경된 파일명도 전달받음
	private void insertMyFile(HttpServletRequest req, String oFileName, String sFileName) {
		// 파일을 제외한 나머지 폼값을 getParameter메서드를 통해 받음
		String title = req.getParameter("title");
		String[] cateArray = req.getParameterValues("cate");
		StringBuffer cateBuf = new StringBuffer();
		if (cateArray == null) {
			cateBuf.append("선택한 항목 없음");
		}
		else {
			for (String s : cateArray) {
				cateBuf.append(s + ", ");
			}
		}
		
		// DTO 객체를 생성하여 전성된 폼값을 담음
		MyFileDTO dto = new MyFileDTO();
		dto.setTitle(title);
		dto.setCate(cateBuf.toString());
		dto.setOfile(oFileName);
		dto.setSfile(sFileName);
		
		// DAO 객체를 생성하고 insertfile메서드를 호출해 데이터를 저장
		MyFileDAO dao = new MyFileDAO();
		dao.insertFile(dto);
		dao.close();
		
	}

}
