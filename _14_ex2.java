package Share;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _14_ex2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int random = (int)(Math.random()*100);
		boolean run = true;
		int count = 0;
		
		
		//System.out.println("컴퓨터가 생각하는 숫자 : " + random);
		
		while(run) {
			try {
				System.out.println("1과 100 사이의 값을 입력하세요 : ");
				int num = scanner.nextInt();
				if(num<random) {
					System.out.println("더 큰 수를 입력하세요.");
					count++;
				}else if(num>random) {
					System.out.println("더 작은 수를 입력하세요.");
					count++;
				}else if(num==random) {
					System.out.println("정답!!");
					System.out.println(count + "번만에 맞추셨습니다.");
					run = false;
				}
		}catch(InputMismatchException e) {
			System.out.println("숫자만 입력할 수 있습니다. 다시 입력해주세요");
			return;
		}

	}

}
}
