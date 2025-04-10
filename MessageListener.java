package Chapter09;

public class MessageListener implements Button.OnClickListener{
	
	@Override
	public void onClick() { //부모의 접근제한자가 public이기에 public 사용해야함.
		System.out.println("메시지를 보냅니다.");
	}
}
