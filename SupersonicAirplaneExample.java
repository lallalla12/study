package Chapter07;

public class SupersonicAirplaneExample {

	public static void main(String[] args) {
		
		SupersonicAirplane sa = new SupersonicAirplane();
		sa.takeOff();
		sa.fly();
		// flyMode에 2 대입
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();
		// flyMode에 1 대입
		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly();
		sa.land();
		

	}

}
