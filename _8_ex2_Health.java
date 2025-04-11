package Share;
import java.util.Scanner;
public class _8_ex2_Health {
	
	
	char gender;
	double tall;
	double weight;
	
	_8_ex2_Health(){
		this.gender = gender;
		this.tall = tall;
		this.weight = weight;
		
	}
	
	void input(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("***** 비만도 Check *****");
		
		System.out.println("성별(M/F) :");
		 gender = scanner.next().toUpperCase().charAt(0);
		
		System.out.println("신장(Cm) :");
		tall = scanner.nextDouble();
		
		System.out.println("체중(Kg) :");
		 weight = scanner.nextDouble();
		
	}
	
	void output1() {
		System.out.println(" 성별 - " + gender);
		System.out.println(" 신장 - " + tall + "Cm");
		System.out.println(" 체중 - " + weight + "Kg");
		
	}
}
