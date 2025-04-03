package Chapter06;

public class CalculatorExample1 {

	public static void main(String[] args) {
		Calculator1 myCalc = new Calculator1();
		// 전원을 켭니다 출력
		myCalc.powerOn();
		
		// x = 5 y = 6 이 대입되며 5+6이 계산되어 출력됨
		int result1 = myCalc.plus(5, 6);
		System.out.println("result1 : " + result1);
		
		
		byte x = 10;
		byte y = 4;
		// 10/4 가 계산되어 출력됨
		double result2 = myCalc.divide(x,y);
		System.out.println("resutl2 : " + result2);
		
		myCalc.powerOff();
	}

}
