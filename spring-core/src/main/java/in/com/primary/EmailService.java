package in.com.primary;

public class EmailService implements MessageService{

	public void sendMessage(String msg) {
		System.out.println("this is message of EmailService "+msg);
		
	}

}
