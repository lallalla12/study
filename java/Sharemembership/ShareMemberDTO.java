package Sharemembership;

public class ShareMemberDTO {
	// 멤버 변수 선언
		private String id;
		private String pass;
		private String name;
		private String birth;
		private String email;
		
		
		// 멤버 변수별 게터와 세터
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getBirth() {
			return birth;
		}
		
		public void setBirth(String birth) {
			this.birth = birth;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
}
