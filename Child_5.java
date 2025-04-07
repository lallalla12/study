package programming.Ch07;

public class Child_5 extends Parent_5 {
	private String name;		// private 접근제한자인 인스턴스 필드
	
	public Child_5() {			// 기본 생성자(매개변수 없는 생성자)
		this("홍길동");			// 11Line (매개변수 한개인 생성자를 호출)
		System.out.println("Child() call");
	}
	
	public Child_5(String name) {	// 매개변수 한개인 생성자
		this.name = name;
		System.out.println("Child(String name) call");
	}
}
