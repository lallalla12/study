package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	/*serialVersionUID는 직렬화된 클래스의 버전 관리에 사용되는 식별자
	 * 선언하지 ㅇ낳아도 실행에는 문제 없지만 선언해주는것이 좋음*/
	private static final long serialVersionUID = 1L;
	@Override
	/* doget메서드를 오버라이딩 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		/* request영역에 message라는 속성으로 데이터를 저장 */
		req.setAttribute("message","Hello Servlet..!!");
		/* req는 doget()메서드의 매개변수로 전달받은 request내장객체*/
		req.getRequestDispatcher("/JSP_CH12/HelloServlet.jsp").forward(req, resp);
	}

}
