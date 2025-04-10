package Chapter09;

public class Button {
	
	// 인터페이스 타입 필드
	// interface 타입  변수명
	OnClickListener listener;
	
	// 메소드
	// 매개 변수의 다형성
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	// 메소드
	void touch() {
		// 구현 객체의 onClick() 메소드 호출
		listener.onClick();
	}
	
	// 중첩 인터페이스
	// interface 선언
	static interface OnClickListener{
	/*public abstract 생략되어있음*/void onClick();
	}
}
