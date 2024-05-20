package in.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.com.dao.UserDaoInt;
import in.com.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	UserDaoInt dao = null;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);

	}

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		UserDTO dto = dao.findByLogin(login);
		return dto;
	}

	//@Transactional(readOnly = true)
	public UserDTO auth(String login, String password) {
		UserDTO dto = dao.auth(login, password);
		return dto;
	}

	@Transactional(readOnly = true)
	public UserDTO findByPK(long pk) {
		UserDTO dto = dao.findByPK(pk);
		return dto;
	}

	@Transactional(readOnly = true)
	public List search(UserDTO dto) {
		List list = dao.search(dto);
		return list;
	}

	@Transactional(readOnly = true)
	public List search(UserDTO dto, int pageNo, int pageSize) {
		List list = dao.search(dto, pageNo, pageSize);
		return list;
	}

}
