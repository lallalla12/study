package sec03.exam01;

public class VariableExchangeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3;
		int y = 5;
		System.out.println("x:" + x + ", y:" + y);
		
		int temp = x; // temp를 선언 후 x를 대입 -> temp = 3
		x = y; // x에 y를 대입 -> x = 5
		y = temp; // y에 temp를 대입 y = 3
		System.out.println("x:" + x + ", y:" + y);
	}

}
