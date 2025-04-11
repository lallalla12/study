package Share;
import java.util.Scanner;
public class _7_ex1_CalculatorTest {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("연산하고자 하는 두 정수값과 연산자를 입력하세요.? ");

        int num1 = scanner.nextInt();
        char op = scanner.next().charAt(0);
        int num2 = scanner.nextInt();

        _7_ex1_Calculator calc = new _7_ex1_Calculator(num1, num2, op);
        System.out.println("연산결과는 " + calc.calculate() + "입니다.");

        scanner.close();
    }
		
		


	}


