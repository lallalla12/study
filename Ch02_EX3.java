package programming;

import java.util.Scanner;

public class Ch02_EX3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 :");
		String strName = scanner.nextLine();

		System.out.print("주민번호 앞 6자리 :");
		String strNumber = scanner.nextLine();
		
		System.out.print("전화번호 :");
		String phoneNumber = scanner.nextLine();
		
		System.out.println("이름 :" + strName);
		System.out.println("주민번호 앞 6자리 :" + strNumber);
		System.out.println("전화번호 :" + phoneNumber);
		
	}

}
