package Chapter06;


public class Calculator2 {
	// 3
	int plus(int x, int y) {
		int result = x+y;
		return result;
	}
	
	// 2
	double avg(int x, int y) {
		double sum = plus(x,y);
		double result = sum / 2;
		return result;
	}
	
	// 1
	void execute() {
		double result = avg(7,10);
		println("실행결과 :" + result);
	}
	
	// 4
	void println(String message) {
		System.out.println(message);
	}
	
}
