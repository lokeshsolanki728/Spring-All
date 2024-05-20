package in.com.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultiple2 {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("Multiple2.xml");
	PersonBean bean =(PersonBean) context.getBean("person");
	System.out.print(bean);
	
	
}
}
