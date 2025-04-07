package Chapter07;

public class SupersonicAirplane extends Airplane {
	public static final int NORMAL = 1;		// 상수(static 키워드가 있으므로, 정적 필드가 됨 -> 객체생성(new)없이 NORMAL로 필드에 class명으로 접근 가능)
	public static final int SUPERSONIC = 2; // 상수(static 키워드가 있으므로, 정적 필드가 됨 -> 객체생성(new)없이 SUPERSONIC으로 필드에 class명으로 접근 가능)
	
	public int flyMode = NORMAL;
	
	@Override
	public void fly() {
		if(flyMode == SUPERSONIC) {
			System.out.println("초음속비행합니다");
		}else {
			// Airplane 객체의 fly() 메소드 호출
			super.fly();
		}
	}
}
