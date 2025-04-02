package Chapter06;

public class Korean {
	
	// 필드
	String nation = "대한민국";
	String name;
	String ssn;
	// 생성자를 생략하려면 기본 생성자 자동 추가
	// 아래와 같이 매개변수 있는 생성자를 추가하면
	// 기본 생성자는 자동으로 추가하지 않음
	// 이때, 기본 생성자를 추가하고 싶으면 수동으로 추가
	Korean(){}
	
	
	// 생성자
	public Korean(String n, String s) {
		name = n;
		ssn = s;
		
	}
}
