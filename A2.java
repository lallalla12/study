package Chapter09;

public class A2 {
	
	// 인스턴스 필드
	B field1 = new B();
	C field2 = new C();
	
	// 인스턴스 메소드
	void method1() {
	B var1 = new B();
	C var2 = new C();
	}
	
	// 정적 필드 초기화
	//static B field3 = new B(); 인스턴스이기 때문에
	static C field4 = new C();
	
	// 정적 메소드
	static void method2() {
		// B var1 = new B(); 인스턴스이기 때문에 
		C var2 = new C();
	}
	
	class B{}
	
	static class C{}
	
}
