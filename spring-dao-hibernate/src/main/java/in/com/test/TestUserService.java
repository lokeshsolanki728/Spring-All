package in.com.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import in.com.dto.UserDTO;
import in.com.service.UserServiceInt;

@Component
public class TestUserService {

	@Autowired
	UserServiceInt service = null;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestUserService test = (TestUserService) context.getBean("testUserService");
		// test.testAdd();
		// test.testUpdate();
		// test.testDelete();
		// test.testFindByLogin();
		// test.testFindByPk();
		test.testAuthenticate();
		//test.testSearch(); 
		//test.testSearch2(); 
	}

	private void testSearch2() {
		UserDTO dto =null;
		List list=service.search(dto,0,2);
		Iterator it =list.iterator();
		while(it.hasNext()) {
			dto = (UserDTO) it.next();
			if (dto != null) {
				System.out.print(dto.getId());
				System.out.print("\t" + dto.getFirstName());
				System.out.print("\t" + dto.getLastName());
				System.out.print("\t" + dto.getLogin());
				System.out.println("\t" + dto.getPassword());
			} else {
				System.out.println("No Record Found");
			}
		}
		
	}

	private void testSearch() {
		UserDTO dto =null;
		List list=service.search(dto);
		Iterator it =list.iterator();
		while(it.hasNext()) {
			dto = (UserDTO) it.next();
			if (dto != null) {
				System.out.print(dto.getId());
				System.out.print("\t" + dto.getFirstName());
				System.out.print("\t" + dto.getLastName());
				System.out.print("\t" + dto.getLogin());
				System.out.println("\t" + dto.getPassword());
			} else {
				System.out.println("No Record Found");
			}
		}
	}

	private void testAuthenticate() {
		UserDTO dto = service.auth("nikhil@gmail.com", "223344");
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.print("\t" + dto.getPassword());
		} else {
			System.out.println("Authenticate ho hi nhi skta");
		}

	}

	private void testFindByPk() {
		UserDTO dto = service.findByPK(2l);
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.print("\t" + dto.getPassword());
		} else {
			System.out.println(" id does't exist");
		}

	}

	private void testFindByLogin() {
		UserDTO dto = service.findByLogin("lokesh@gmail.com");
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.print("\t" + dto.getPassword());
		} else {
			System.out.println("login id does't exist");
		}

	}

	private void testDelete() {
		service.delete(2l);

	}

	private void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(3l);
		dto.setFirstName("Lokesh");
		dto.setLastName("kk");
		dto.setLogin("lokesh@gmail.com");
		dto.setPassword("1122");
		service.update(dto);
	}

	private void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("Nikhil");
		dto.setLastName("khandait");
		dto.setLogin("nikhil@gmail.com");
		dto.setPassword("223344");
		service.add(dto);

	}
}
