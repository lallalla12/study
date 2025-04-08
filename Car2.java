package Chapter07;

public class Car2 {
	
	// 필드
	// 자동차는 4개의 타이어를 가짐
	Tire FrontLeftTire = new Tire("앞왼쪽", 6);
	Tire FrontRightTire = new Tire("앞오른쪽", 2);
	Tire BackLeftTire = new Tire("뒤왼쪽", 3);
	Tire BackRightTire = new Tire("뒤오른쪽", 4);
	
	// 생성자
	
	// 메소드
	// 모든 타이어를 1회 회전시키기 위해 각 Tire 객체의 roll() 메소드를 호출.
	// false를 리턴하는 roll()이 있을 경우 stop() 메소드를 호출하고 해당 타이어 번호를 리턴
	int run() {
		System.out.println("[자동차가 달립니다");
		if(FrontLeftTire.roll()==false) {stop(); return 1;}
		if(FrontRightTire.roll()==false) {stop(); return 2;}
		if(BackLeftTire.roll()==false) {stop(); return 3;}
		if(BackRightTire.roll()==false) {stop(); return 4;}
		return 0;
	}
	
	// 펑크 났을 때 실행
	void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}
}
