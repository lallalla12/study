package Share;

public class _12_KakaoSender implements _12_MessageSender {
	@Override
	 public void sendMessage(String recipient, String message) {
	 System.out.println("[카톡 전송]");
	 System.out.println("카톡 ID: " + recipient);
	 System.out.println("내용: " + message);
	 }
}
