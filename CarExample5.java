package Chapter06;

public class CarExample5 {

	public static void main(String[] args) {
		Car5 myCar = new Car5();
		
		// Car의 setGas() 메소드 호출
		// gas에 5를 대입
		myCar.setGas(5);
		
		// Car의 is LeftGas() 메소드 호출
		boolean gasState = myCar.isLeftGas();
		if(gasState) {
			System.out.println("출발합니다");
			// Car의 run() 메소드 호출
			myCar.run();
		}
		
		if(myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		}else {
			System.out.println("gas를 주입하세요");
		}

	}

}
