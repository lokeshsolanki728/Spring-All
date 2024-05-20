package in.com.collaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestCollaction {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Collaction.xml");
		MyBean c = (MyBean) context.getBean("myBean");
		c.displayData();
	}

}
