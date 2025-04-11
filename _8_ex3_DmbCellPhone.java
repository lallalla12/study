package Share;

public class _8_ex3_DmbCellPhone extends _8_ex3_CellPhone {
	
			// 필드, 부모의 필드도 물려받았기에 model과 color 필드도 있음
			int channel;
			
			// 생성자
			_8_ex3_DmbCellPhone(String model, String color, int channel){
				this.model = model;
				this.color = color;
				this.channel = channel;
			}
			
			// 메소드
			void turnOnDmb() {
				System.out.println("채널" + channel + "번 DMB 방송 수신을 시작합니다." );
			}
			void changeChannelDmb(int channel) {
				this.channel = channel;
				System.out.println("채널 " + channel + "번으로 바꿉니다");
			}
			void turnOffDmb() {
				System.out.println("DMB 방송 수신을 멈춥니다");
			}
}
