package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImp implements UserServiceInt {

	@Autowired
	private UserDAOInt dao = null;

	@Transactional(propagation = Propagation.REQUIRED)

	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		if (dto.getLogin().equals("admin")) {
			throw new RuntimeException("User with login 'admin' not allowed.");
		}

		return pk;
	}

	@Override
	public void update(UserDTO dto) {
		dao.update(dto);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public UserDTO findByLogin(String login) {
		UserDTO dto = new UserDTO();
		dto = dao.findByLogin(login);
		return dto;
	}

	@Override
	public UserDTO findByPK(long pk) {
		UserDTO dto = new UserDTO();
		dto = dao.findByPK(pk);
		return dto;
	}

	@Override
	public UserDTO authenticate(String login, String password) {
		UserDTO dto = new UserDTO();
		dto = dao.authenticate(login, password);
		return dto;
	}

	@Override
	public List search() {
		UserDTO dto = new UserDTO();
		List list = dao.search();
		return list;
	}

	@Override
	public List search(UserDTO dto, int pageNo, int pageSize) {
		List list = dao.search(dto, pageNo, pageSize);
		return list;
	}

}
