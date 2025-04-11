package Share;

public class _12_EmaliSender implements _12_MessageSender {
	@Override
	 public void sendMessage(String recipient, String message) {
	 System.out.println("[이메일 전송]");
	 System.out.println("받는 사람: " + recipient);
	 System.out.println("내용: " + message);
	 }
}
