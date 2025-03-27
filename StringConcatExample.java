package sec03.exam01;

public class StringConcatExample {

	public static void main(String[] args) {
		// 숫자 연산
		int value = 10 + 2 + 8;
		System.out.println("value: " + value);
		
		//문자열 결합 연산
		String str1 = 10 + 2 + "8"; // 숫자 10과 2를 먼저 계산한 후 문자열 "8"을 결합
		System.out.println("str1: " + str1);
		
		String str2 = 10 + "2" + 8; // 숫자 10과 문자열 "2"를 먼저 결합후 숫자 8 결합
		System.out.println("str2: " + str2);
		
		String str3 = "10" + 2 + 8; // 문자열 "10"과 숫자 2를 먼저 결합후 숫자 8 결합
		System.out.println("str3: " + str3);
		
		String str4 = "10" + (2 + 8); // 괄호 안 숫자 2와 8 먼저 계산 후 문자열 10 결합
		System.out.println("str4: " + str4);
		
	}

}
