package Share;
import java.util.Scanner;
public class _8_ex3 {

	public static void main(String[] args) {
		int choice;
		int choice2;
		char choice3;
		boolean run = true;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("모델명을 입력하세요");
		String name = scanner.nextLine();
		
		System.out.println("색상을 입력하세요");
		String color = scanner.nextLine();
		
		System.out.println("채널을 입력하세요");
		int channel = scanner.nextInt();
		
		System.out.println("============================================================================================\r\n"
				+ "1. 전원 켬 2. 전원 끔 3. 전화 받기 4. DMB 켜기 5. DMB채널 바꾸기 6. DMB 끄기 \r\n"
				+ "============================================================================================");
		
		while(run) {
			System.out.println("하시고자 하는 기능을 선택하세요. >");
		choice  = scanner.nextInt();
		
		if(choice == 1) {
			System.out.println("전원을 켭니다.");
		}else if(choice == 2) {
			System.out.println("전원을 끕니다.");
			run = false;
		}else if(choice == 3) {
			System.out.println("벨이 울립니다");
			while(run) {
				System.out.println("===========================================\r\n"
					+ "      1. 말한다. 2. 듣는다. 3. 전화를 끊는다.\r\n"
					+ "     ===========================================\r\n"
					+ "     1번, 2번, 3번 중 하나를 선택하세요.>");
			choice2  = scanner.nextInt();
				if(choice2 == 1 ) {
					System.out.println("상대방에게 하시고자 하는 메세지를 입력하세요.> ");
					choice3 = scanner.next().toUpperCase().charAt(0);
					System.out.println("나 : " + choice3);
				}else if(choice2 == 2) {
					System.out.println("상대방에게 하시고자 하는 메세지를 입력하세요.> ");
					choice3 = scanner.next().toUpperCase().charAt(0);
					System.out.println("상대방 : "+ choice3);
				}else if(choice2 == 3) {
					System.out.println("전화를 끊습니다");
					break;
				}
				
			}
			
			
		}else if(choice == 4) {
				System.out.println("채널 "+channel + "번 DMB 방송 수신을 시작합니다.");
				
			}else if(choice == 5) {
				System.out.println("");
			}
		
		
		
		}
		
		
		
		
	}

}
