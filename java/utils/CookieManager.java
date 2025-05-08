package utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieManager {
	// 명시한 이름, 값, 유지 기간 조건으로 새로운 쿠키를 생성
	public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime) {
		Cookie cookie = new Cookie(cName, cValue);		// 쿠키생성
		// 경로는 "/"로 설정했으므로 웹 애플리케이션 전체에 사용되는 쿠키를 만듬
		cookie.setPath("/");							// 경로 설정
		cookie.setMaxAge(cTime);						// 유지 기간 설정
		response.addCookie(cookie);						// 응답 객체에 추가
		
	}
	
	// 명시한 이름의 쿠키를 찾아 그 값을 반환
	public static String readCookie(HttpServletRequest request, String cName) {
		String cookieValue = "";	// 반환 값
		// request에서 쿠키 목록을 받아서
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				String cookieName = c.getName();
				// cName과 같은 쿠키가 있으면 그 값을 반환
				if(cookieName.equals(cName)) {
					cookieValue = c.getValue();			// 반환 값 갱신
				}
			}
		}
		return cookieValue;
	}
	
	// 명시한 이름의 쿠키를 삭제함
	public static void deleteCookie(HttpServletResponse response, String cName) {
		makeCookie(response, cName, "", 0);
	}

}
