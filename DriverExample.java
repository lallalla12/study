package Chapter07;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		// 자동타입변환 : Vehicle vehicle = bus;
		driver.drive(bus);
		// 자동타입변환 : Vehicle vehicle = taxi;
		driver.drive(taxi);
	}
}
