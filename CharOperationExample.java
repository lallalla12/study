package Chaptor03;

public class CharOperationExample {

	public static void main(String[] args) {
		char c1 = 'A' + 1;			// 'A'의 유니코드 65
		char c2 = 'A';
		// char c3 =  c2 + 1;		char 변수가 산술 연산에 사용되면 int타입으로 변환되므로 연산 결과는 int타입이 됨
		char c3 = (char) (c2+1);	// 강제 타입 변환을 하여 char 타입으로 결과 얻기 가능
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		System.out.println("c3 : " + c3);
				

	}

}
