package Chapter08;

public class SmartTelevisionExample {

	public static void main(String[] args) {
		
		SmartTelevision tv = new SmartTelevision();
		
		RemoteControl rc = tv;
		Searchable searchable = tv;
		
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(20);
		//rc.reach()
		searchable.search("www.naver.com");
	}

}
