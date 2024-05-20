package in.com.autoWire.bytetype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWireByType {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AutoWire-bytype.xml");
		UserDaoImpl udi = (UserDaoImpl) context.getBean("userdao");
		udi.add();
		
	}
}
