package Share;

public class _8_ex3_CellPhone {
	
	String model;
	String color;
	
	// 생성자
	
	// 메소드
	void powerOn() { System.out.println("전원을 켭니다.");}								// 인스턴스 메소드
	void powerOff() { System.out.println("전원을 끕니다.");}							// 인스턴스 메소드
	void bell() { System.out.println("벨이 울립니다.");}								// 인스턴스 메소드
	void sendVoice(String message) { System.out.println("자기 : " + message);}		// 인스턴스 메소드
	void receiveVoice(String message) { System.out.println("상대방 : " + message);}	// 인스턴스 메소드
	void hangUp() { System.out.println("전화를 끊습니다");}		
}
