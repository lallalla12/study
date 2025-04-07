package Chapter07;

public class Computer extends Calculator{
	// 재정의
	// 생략 가능해도 괜찮음 , areaCircle() 메소드가 정확히 재정의된 것인지 컴파일러가 확인하기 때문에 실수를 줄여줌
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		// 좀 더 정밀한 계산을 위해 Math.PI 상수 사용
		return Math.PI * r * r;
	}
	
}
