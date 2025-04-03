package Chapter06;

public class CarExample6 {

	public static void main(String[] args) {
		Car6 myCar = new Car6();
		myCar.keyTurnOn();
		myCar.run();
		int speed = myCar.getSpeed();
		System.out.println("현재 속도 : " + speed + "km/h");

	}

}
