package Chapter07;

public class sportsCar extends Car{
	@Override
	public void speedUp() {
		speed += 10;
	}
	
	// 재정의 불가능
	//@Override
	//public void stop() {
	//	System.out.println("스포츠카를 멈춤");
	//	speed = 0;
	//}


}
