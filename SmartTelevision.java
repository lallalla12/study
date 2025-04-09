package Chapter08;

public class SmartTelevision implements RemoteControl, Searchable{
	
	private int volume;
	
	// turnOn() 추상 메소드의 실체 메소드
	public void turnOn() {
		System.out.println("Tv를 켭니다");
	}
	
	// turnOff() 추상 메소드의 실체 메소드
	public void turnOff() {
		System.out.println("Tv를 끕니다");
	}
	
	// setVolume() 추상 메소드의 실체 메소드
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}
	
	public void search(String url) {
		// saerchable의 추상 메소드에 대한 실체 메소드
		System.out.println(url + "을 검색합니다. ");
	}
}
