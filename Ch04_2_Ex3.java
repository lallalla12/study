package programming;

public class Ch04_2_Ex3 {

	public static void main(String[] args) {
		
		while(true) { 		// 무한반복
			int num1 = (int)(Math.random()*6) + 1;				// 주사위1
			int num2 = (int)(Math.random()*6) + 1;				// 주사위2
			int sum = num1+num2;								// 주사위1 + 주사위2
			System.out.println("("+ num1 +"," + num2 + ")");	
			if(sum==5) {										// 주사위1 + 주사위2의 합이 5이면,
				break;											// 멈춰라
			}
		}
		
	}

}
