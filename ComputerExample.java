package Chapter06;

public class ComputerExample {

	public static void main(String[] args) {
		Computer myCom = new Computer();
		
		// sum1() 메소드를 호출할 때 배열을 넘겨줌으로써 배열의 항목 값들을 모두 전달할 수 있음
		// 배열의 항목 수는 호출할 때 결정
		int[] values1 = {1, 2, 3};
		int result1 = myCom.sum1(values1);
		// 1+2+3의 값 출력
		System.out.println("result1 : " + result1);
		
		int result2 = myCom.sum1(new int [] {1,2,3,4,5});
		// 1+2+3+4+5 의 값 출력
		System.out.println("result2 : " + result2);
		
		// ...로 선언된 매개 변수의 값은 쉼표로 나열해주면 됨
		int result3 = myCom.sum2(1, 2, 3);
		// 1+2+3의 값 출력
		System.out.println("result3 : " + result3);
		
		int result4 = myCom.sum2(1,2,3,4,5);
		// 1+2+3+4+5 의 값 출력
		System.out.println("result4 : " + result4);

	}

}
