package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOJDBCImp implements UserDAOInt {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long add(UserDTO dto) {
		String sql = "INSERT INTO USERDTO VALUES(?,?,?,?,?)";
		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
		dto.getPassword());
		return pk;
	}

	@Override
	public void update(UserDTO dto) {
		String sql = "UPDATE USERDTO SET FIRSTNAME=?,LASTNAME=?,LOGIN=?,PASS=? WHERE ID =?";
		jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(), dto.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "delete from userdto where id=?";
		jdbcTemplate.update(sql,id);
	}

	@Override
	public UserDTO findByLogin(String login) {
		UserDTO dto = new UserDTO();
		String sql = "select id,firstName,lastName,login,pass from userdto where login=?";
		Object[] param = {login};
		dto= jdbcTemplate.queryForObject(sql,param,new UserMapper());
		return dto;
	}

	@Override
	public UserDTO authenticate(String login, String password) {
		UserDTO dto = new UserDTO();
		String sql = "select id,firstName,lastName,login,pass from userdto where login=? and pass=?";
		Object[] param = {login,password};
		dto= jdbcTemplate.queryForObject(sql,param,new UserMapper());
		return dto;
	}

	@Override
	public UserDTO findByPK(long pk) {
		
		UserDTO dto = new UserDTO();
		String sql = "select id,firstName,lastName,login,pass from userdto where id=?";
		Object[] param = {pk};
		dto= jdbcTemplate.queryForObject(sql,param,new UserMapper());
		return dto;
	}

	@Override
	public List search() {
		String sql = "select id,firstName,lastName,login,pass from userdto";
		List list= jdbcTemplate.query(sql,new UserMapper());
		return list;

	}

	@Override
	public List search(UserDTO dto, int pageNo, int pageSize) {
		String sql = "select id,firstName,lastName,login,pass from userdto limit "+pageNo+" , "+pageSize;
		List list= jdbcTemplate.query(sql,new UserMapper());
		return list;
	}

}
