package in.com.primary;

public class NotificationService {
	private MessageService ms;

	public void setMessageService(MessageService ms) {
		this.ms = ms;
	}

	public void sedNotification(String msg) {
		ms.sendMessage(msg);
	}

}
