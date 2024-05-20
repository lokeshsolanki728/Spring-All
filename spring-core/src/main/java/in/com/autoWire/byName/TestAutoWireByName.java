package in.com.autoWire.byName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWireByName {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("AutoWire-ByName.xml");
	UserDaoimpl udi = (UserDaoimpl) context.getBean("UserDao");
	udi.add();
}
}
