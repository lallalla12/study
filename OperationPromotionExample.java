package sec03.exam01;

public class OperationPromotionExample {

	public static void main(String[] args) {
		
		byte btyeValue1 = 10;
		byte btyeValue2 = 20;
		// byte btyeValue3 = btyeValue1 + btyeValue2; int타입으로 자동변환이 되었기 때문에 컴파일 에러
		int intValue1 = btyeValue1 + btyeValue2;
		System.out.println(intValue1);
		
		char charValue1 = 'A';
		char charValue2 = 1;
		// char charValue3 = charValue1 + charValue2; int타입으로 자동변환이 되었기 때문에 컴파일 에러
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드 =" + intValue2);
		System.out.println("출력문자 =" + (char)intValue2); // char로 강제변환 
		
		int intValue3 = 10;
		int intValue4 = intValue3/4;
		System.out.println(intValue4); // 정수로 계산되기때문에 2가 출력
		
		int intValue5 = 10;
		// int intValue6 = 10/4.0; double로 자동변환이 되어 컴파일 에러
		double doubleValue = intValue5 / 4.0;
		System.out.println(doubleValue); //double이기에 소수점까지 표현
		
		int x = 1;
		int y = 2;
		double result = (double) x / y; //double로 강제변환하였기에 0.5출력
		System.out.println(result);
		
		
		
	}

}
