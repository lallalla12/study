package Chapter07;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child();
		
		// 자동 타입 변환
		Parent parent =child;
		// 재정의돈 메소드가 호출됨
		parent.method1();
		parent.method2();
		// 호출 불가능
		//parent.method3();

	}

}
