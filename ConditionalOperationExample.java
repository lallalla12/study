package Chaptor03;

public class ConditionalOperationExample {

	public static void main(String[] args) {
		int score = 85;
		
		// socre의 값이 90이상이면 'A'출력 , 80이상이면 'B' 아니면 'C' 출력
		char grade = (score>90) ? 'A' : ((score > 80) ? 'B' : 'C');
		System.out.println(score + "점은" + grade + "등급입니다.");
	}

}
