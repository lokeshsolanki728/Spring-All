package in.com.autoWire.notype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWireByNoType {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AutoWire-bynotype.xml");
		UserDaoImpl udi = (UserDaoImpl) context.getBean("userDao");
		udi.add();
		
	}
}
