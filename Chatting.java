package programming.Ch09;

public class Chatting {
	void startChat(String chatId) {
		String nickName = null;
		nickName = chatId;
		
		class Chat {
			public void start() {
				while (true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "]" + inputData;
					sendMessage(message);
				}
			}
			
			void sendMessage(String message) {
				
			}
		}
		
		Chat chat = new Chat();
		chat.start();
	}
}
