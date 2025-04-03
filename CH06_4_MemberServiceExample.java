package programming.Ch06;

public class CH06_4_MemberServiceExample {

	public static void main(String[] args) {
		CH06_4_Member_Service memberService = new CH06_4_Member_Service();
		boolean result = memberService.login("hong", "12345");
		if(result) {
			System.out.println("로그인 되었습니다");
			memberService.logout("hong");
		}else {
			System.out.println("id 또는 password가 올바르지 않습니다");
		}

	}

}
