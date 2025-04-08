package Chapter07;

public class ChildExample2 {
	public static void main(String[] args) {
		// 자동 타입 변환
		Parent2 parent = new Child2();
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		
		/*
		불가능
		parent.field2 = "data2";
		parent.method3();
		*/
		
		// 강제 타입 변환
		Child2 child = (Child2) parent;
		// 가능
		child.field2 = "yyy";
		child.method3();
	}
}
