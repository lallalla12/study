package Share;
import java.util.Scanner;
public class _12_MessageTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("전송 방식 선택 : 1.email  2.sms  3.kakao");
		int choice = scanner.nextInt();
		
		_12_MessageSender sender = null;
		

		if(choice == 1) {
			sender = new _12_EmaliSender();

			 System.out.println();
		}else if (choice == 2) {
			sender = new _12_SmsSender();
			
			System.out.println();
		}else if (choice == 3) {
			 sender = new _12_KakaoSender();
			 
		}else {
			System.out.println("1,2,3 중 선택.");
		}
		
		System.out.println("받는 사람 : ");
		// 개행 제거를 위해 사용
		scanner.nextLine();
		String recipient = scanner.nextLine();
		System.out.println("메시지 : ");
		String message = scanner.nextLine();
		
		sender.sendMessage(recipient, message);

		
	}

}
