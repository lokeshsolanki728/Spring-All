package in.com.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestNotification {
public static void main(String[] args) {
	ApplicationContext contax = new ClassPathXmlApplicationContext("Primary.xml");
	NotificationService nts = (NotificationService) contax.getBean("notificationService");
	nts.sedNotification("--- hello");
}
}
