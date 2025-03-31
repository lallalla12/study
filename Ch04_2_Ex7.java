package programming;
import java.util.Scanner;
public class Ch04_2_Ex7 {

	

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료" );
			System.out.println("-----------------------------");
			System.out.print("선택>");
			// 선택한 값 정수로 변경
			int select =Integer.parseInt(scanner.nextLine());
			
			
			
			
			// 1을 선택하면
			if (select == 1) {
				// 예금액 >이 출력되면서 10000을 a에 저장
				System.out.printf("예금액>");
				// 잔고 = 잔고(0원) + 금액(10,000원) 
				balance += Integer.parseInt(scanner.nextLine());
				
				
				
			}else if(select == 2) {
				// 예금액 >이 출력되면서 출금액 입력하면 sum1에서 빠져야됨
				System.out.printf("출금액>");
				// 잔고 = 잔고(10,000원) - 금액(2,000원) 
				balance -= Integer.parseInt(scanner.nextLine());
				
			}else if(select == 3) {
				// 예금액 >이 출력되면서 출금액 입력하면 sum1에서 빠져야됨
				System.out.println("잔고>" + balance);
			
			}else if(select == 4) {
			System.out.printf("프로그램 종료");
			run = false;
		}
		
	}
		

	}
}

