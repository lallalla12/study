package Chapter06;

public class Calculator1 {
	
	//메소드
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	int plus(int x, int y) {
		int result = x+y;
		return result;
	}
	
	double divide(int x, int y ) {
		// 강제 타입변환
		double result = (double) x / (double) y;
		return result;
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다");
	}
}
