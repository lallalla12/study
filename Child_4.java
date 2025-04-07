package programming.Ch07;

public class Child_4 extends Parent_4 {
	private int studentNo;
	
	// 접근제한자가 public인 매개변수 두개인 생성자
	public Child_4(String name, int studentNo) {
		super(name);
		this.studentNo = studentNo;
	}
}
