package Chaptor03;

public class ArithmeticOperatorExample {

	public static void main(String[] args) {
		int v1 = 5;
		int v2 = 2;
		
		int result1 = v1 + v2;
		System.out.println("result1 = " + result1);
		
		int result2 = v1 - v2;
		System.out.println("result2 = " + result2);
		
		int result3 = v1 * v2;
		System.out.println("result3 = " + result3);
		
		int result4 = v1 / v2;
		System.out.println("result4 = " + result4); // int를 int로 나눈 결과는 소수점 버리고 출력됨, 소수점 까지 출력하고 싶다면 둘 중 하나가 실수 타입이어야함
		
		int result5 = v1 % v2;
		System.out.println("result5 = " + result5);
		
		double result6 = (double) v1 / v2;
		System.out.println("result6 = " + result6);
	}

}
