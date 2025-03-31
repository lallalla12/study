package programming;

public class Ch04_2_Ex4 {

	public static void main(String[] args) {
		for (int x=1; x<=10; x++) {			// x는 1부터 10까지(x는 10이하의 자연수)
			for (int y=1; y<=10; y++) {		// y는 1부터 10까지(y는 10이하의 자연수)
				if(4*x + 5*y ==60) {
					System.out.println("("+x+","+y+")");
				}
			}
			
		}
	}

}
