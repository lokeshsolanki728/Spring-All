package in.com.lifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycleBoth {

	public static void main(String[] args) {

//		//for Attributes of LifeCycle
//		ApplicationContext context = new ClassPathXmlApplicationContext("LifeCycle.xml");	
//	    LifeCycleAttribute lca = (LifeCycleAttribute) context.getBean("lifeCycle");	
//	    ((ClassPathXmlApplicationContext) context).close();

		// for anootation of LifeCycle
		ApplicationContext context2 = new ClassPathXmlApplicationContext("LifeCycle2.xml");
		LifeCycleAnnotation lcano = (LifeCycleAnnotation) context2.getBean("lifeCycle2");
		((ClassPathXmlApplicationContext) context2).close();
	}
}
