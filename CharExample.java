package sec03.exam01;

public class CharExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c1 = 'A';		// 문자를 직접 저장
		char c2 = 65;		// 10진수로 저장, "A"의 유니코드 
		char c3 = '\u0041';	// 16진수로 저장, "A"의 유니코드 
		
		char c4 = '가'; 		// 문자를 직접 저장
		char c5 = 44032;	// 10진수로 저장, "가"의 유니코드 
		char c6 = '\uac00';	// 16진수로 저장,	"가"의 유니코드

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
	}

}
