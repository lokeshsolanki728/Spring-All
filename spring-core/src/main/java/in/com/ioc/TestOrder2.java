package in.com.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Order2.xml");
		Order2 order2 =(Order2) context.getBean("order2");
		order2.bookTickets(5);
	}

}
