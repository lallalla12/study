package programming;
import java.util.Scanner;

public class Ch05_2_Ex06 {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		
		
		while(run) {	// 무한 반복
			System.out.println("----------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수 입력 | 3. 점수 리스트 | 4. 분석 | 5. 종료");
			System.out.println("----------------------------------------------------");
			System.out.print("선택>");
			
			// 정수로 바꿈
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			// 1일때, 
			if(selectNo == 1) {
				System.out.print("학생 수>");
				// 입력받은 학생 수를 정수로 바꿈
				studentNum = Integer.parseInt(scanner.nextLine());
				
				// 2일때,
			}else if(selectNo == 2) {
				// 입력받은 학생수로 배열 크기 생성 
				scores = new int[studentNum];
				for(int i=0;i<scores.length;i++) {
					System.out.print("scores["+i+"] >");
					// 배열 값을 입력받음
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
			// 3일때,
			}else if(selectNo == 3) {
				for(int i = 0; i<scores.length; i++) {
					// 배열 값을 출력
					System.out.println("scores[" + i + "] > " + scores[i]);
				}
			// 4일때, 
			}else if(selectNo == 4) {
				int max = 0;
				for(int i=0; i<scores.length; i++) {
					// 배열 값의 합
					sum += scores[i];
					// 배열을 비교하여 최댓값 구하기
					if(scores[i]>max) {
						max = scores[i];
						
					}
					 
				}
				// 배열 값의 평균 구하기
				double avg = (double) sum / scores.length;
				System.out.println("최고 점수 :" + max);
				System.out.println("평균 점수 : " + avg);
				
				
			}else if(selectNo == 5) {
				System.out.println("프로그램 종료");
				// 무한반복을 false로 입력하여 종료하기
				run = false;
				
			}
			
		}

	}

}
