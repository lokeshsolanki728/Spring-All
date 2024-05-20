package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt service = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

		// test.testAdd();
		// test.testUpdate();
		// test.testDelete();
		// test.testAuthenticate();
		// test.testFindByPk();
		// test.testFindByLogin();
		// test.testSearch();
		 test.testSearch2();

	}

	private void testSearch2() {
		UserDTO dto = null;
		List  list = service.search(dto,0,5);
		Iterator< UserDTO> it= list.iterator();
		while(it.hasNext()) {
			dto=(UserDTO)it.next();
			if(dto!=null) {
				System.out.println(dto.getId());
				System.out.println(dto.getFirstName());
				System.out.println(dto.getLastName());
				System.out.println(dto.getLogin());
				System.out.println(dto.getPassword());
			} else {
				System.out.println("koi bhi nahii ..");
			}
		}
	}

	private void testSearch() {
		UserDTO dto = null;
		List  list = service.search();
		Iterator< UserDTO> it= list.iterator();
		while(it.hasNext()) {
			dto=(UserDTO)it.next();
			if(dto!=null) {
				
				System.out.println(dto.getId());
				System.out.println(dto.getFirstName());
				System.out.println(dto.getLastName());
				System.out.println(dto.getLogin());
				System.out.println(dto.getPassword());
			} else {
				System.out.println("koi bhi nahii ..");
			}
		}
	}

	private void testFindByLogin() {
		UserDTO dto = new UserDTO();
		dto = service.findByLogin("nikhil@gmail.com");
		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		} else {
			System.out.println("koi bhi nahii ..");
		}
	}

	private void testFindByPk() {
		UserDTO dto = new UserDTO();
		dto = service.findByPK(1l);
		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		} else {
			System.out.println("koi bhi nahii ..");
		}
	}

	private void testAuthenticate() {
		UserDTO dto = new UserDTO();
		dto = service.authenticate("nikhil@gmail.com", "nikhil@123");
		System.out.println("FirstName is :" + dto.getFirstName());
		System.out.println("LastNAme is :" + dto.getLastName());

	}

	private void testDelete() {
		UserDTO dto = new UserDTO();
		service.delete(2);
		System.out.println("delete ho gya ");

	}

	private void testUpdate() {
		UserDTO dto = new UserDTO();

		dto.setFirstName("Lokes");
		dto.setLastName("Khandait");
		dto.setLogin("nikhil@gmail.com");
		dto.setPassword("nikhil@123");
		dto.setId(1);

		service.update(dto);
		System.out.println("Data updated .....pk =");

	}

	private void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Amit");
		dto.setLastName("Khandait");
		dto.setLogin("nikhil@gmail.com");
		dto.setPassword("nikhil@123");

		long pk = service.add(dto);
		System.out.println("Data Added .....pk = " + pk);

	}

}
