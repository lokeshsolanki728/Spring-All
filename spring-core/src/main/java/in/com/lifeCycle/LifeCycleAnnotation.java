package in.com.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycleAnnotation {
	@PostConstruct
	public void init() {
		System.out.println("this is init method ...");
	}
	 @PreDestroy
	 public void destroy() {
		 System.out.println("this is destroy Method...");
	 }
}
