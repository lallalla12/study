package Chapter05;

public class MainStringArrayArgument {

	public static void main(String[] args) {
		// 입력된 데잍터 개수가 2개가 아닐 경우
		if(args.length != 2) {
			System.out.println("값의 수가 부족합니다");
			// 프로그램 강제 종료
			System.exit(0);
		}
		
		// 데이터 얻기
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		// 문자열을 정수로 변환
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		System.out.println(num1 + "+" + num2 + "=" + result);

	}

}
