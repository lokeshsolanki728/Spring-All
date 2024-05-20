package in.com.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class TestUser {

	public static void main(String[] args) {
		BeanFactory f = new XmlBeanFactory( new ClassPathResource("UserBean.xml"));
		UserBean bean =(UserBean)f.getBean("user");
		System.out.println(bean);
			
	}

}
