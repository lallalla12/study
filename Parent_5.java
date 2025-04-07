package programming.Ch07;

public class Parent_5 {
	public String nation;	// public 접근제한자인 인스턴스 필드
	
	public Parent_5() {		// 기본 생성자(매개변수 없는 생성자)
		this("대한민국");		// 11 Line(매개변수 한개인 생성자 호출)
		System.out.println("Parent() call");
	}
	
	public Parent_5(String nation) { // 매개변수 한개인 생성자
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
