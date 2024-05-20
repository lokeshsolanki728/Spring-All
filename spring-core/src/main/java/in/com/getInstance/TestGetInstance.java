package in.com.getInstance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetInstance {
public static void main(String[] args) {
	ApplicationContext contax = new ClassPathXmlApplicationContext("Instance.xml");
	GetInstance1 instance = (GetInstance1) contax.getBean("instance");
	 GetInstance1 s =instance.getInstance();
}
}
