package Chapter07;

public class HankookTire extends Tire {
	// 필드
	// 생성자
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	// 다른 내용을 출력하기 위해 재정의한 roll() 메소드
	@Override
	public boolean roll() {
		++accumulateRotation;
		if(accumulateRotation<maxRotation) {
			// 정상 회전(누적<최대)일 경우 실행
			System.out.println(location + "HankookTire 수명 : " + 
					(maxRotation-accumulateRotation) + "회");
			return true;
		}else {
			// 펑크(누적=최대)일 경우 시행
			System.out.println("***" + location + "HankookTire 펑크 ***");
			return false;
			
		}
	}
}
