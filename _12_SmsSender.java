package Share;

public class _12_SmsSender implements _12_MessageSender{
	@Override
	 public void sendMessage(String recipient, String message) {
	 System.out.println("[SMS 전송]");
	 System.out.println("받는 사람 번호: " + recipient);
	 System.out.println("메시지: " + message);
	 }
}
