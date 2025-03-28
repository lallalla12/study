package Chaptor03;

public class StringConcatExample {

	public static void main(String[] args) {
		String str1 = "JDK" + 6.0;		// 문자열 "JDK 6.0"으로 저장
		String str2 = str1 + " 특징";		// 문자열로 결합됨
		System.out.println(str2);
		
		String str3 = "JDK" + 3 +3.0;	// 문자열 "JDK3" 결합 후 "3.0"결합됨
		String str4 = 3 + 3.0 + "JDK";	// 숫자 3과 3.0 먼저 계산후 "JDK"와 결합
		System.out.println(str3);
		System.out.println(str4);
		

	}

}
