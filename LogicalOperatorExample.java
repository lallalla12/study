package Chaptor03;

public class LogicalOperatorExample {

	public static void main(String[] args) {
		int charCode = 'A';
		
		if((charCode>=65) & (charCode<=90)) {
			// charCode가 65보다 크거나 같고 90보다 작거나같으면 참
			System.out.println("대문자군요");
		}
		
		if((charCode>=97) & (charCode<=122)) {
			// charCode가 97보다 크거나 같고 122보다 작거나 같으면 참
			System.out.println("소문자군요");
		}
		
		if(!(charCode<48) && !(charCode>57)) {
			// charCode가 48보다 작고 57보다 큰게 아니면 참
			System.out.println("0~9 숫자군요");
		}
		
		int value = 6;
		
		if((value%2==0) | (value%3==0)) {
			// value를 2로 나눈 나머지가 0이거나 3으로 나눈 나머지가 0이면 참
			System.out.println("2 또는 3의 배수군요");
		}
		
		if((value%2==0) || (value%3==0)) {
			// value를 2로 나눈 나머지가 0이거나 3으로 나눈 나머지가 0이면 참
			System.out.println("2 또는 3의 배수군요");
		}

	}

}
