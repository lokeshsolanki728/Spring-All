package in.com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryExample {

	@Autowired
	private BeanFactory f;

	public void doSomething() {
		MyComponent myc = f.getBean(MyComponent.class);
		myc.doSomething();
		
		Role role = f.getBean(Role.class);
		role.doSomething();
	}
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("in.com.test");

		context.register(AppConfig.class);

		// context.refresh();

		BeanFactoryExample example = context.getBean(BeanFactoryExample.class);

		example.doSomething();

		context.close();
	}

}
