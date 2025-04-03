package programming.Ch06;

public class CH06_4_Member_Service {
	
	String id;
	String password;
	
	boolean login(String id, String password ) {
		if(id.equals("hong") && password.equals("12345")) {
			return true;
		}else {
			return false;
		}
		
	}
	
	void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
}
