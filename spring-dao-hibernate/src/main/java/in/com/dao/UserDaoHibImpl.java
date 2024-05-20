package in.com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.com.dto.UserDTO;

@Repository
public class UserDaoHibImpl implements UserDaoInt {

	@Autowired
	private SessionFactory sessionFactory = null;

	public long add(UserDTO dto) throws DataAccessException {
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(UserDTO dto) throws DataAccessException {
		sessionFactory.getCurrentSession().update(dto);
	}

	public void delete(long id) throws DataAccessException {
		UserDTO dto = new UserDTO();
		dto.setId(id);
		sessionFactory.getCurrentSession().delete(dto);
	}

	public UserDTO findByLogin(String login) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(UserDTO.class);
		c.add(Restrictions.eq("login", login));
		List list = c.list();
		UserDTO dto = null;
		if (list != null && list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

	public UserDTO auth(String login, String password) throws DataAccessException {
		Query q = sessionFactory.getCurrentSession().createQuery("from UserDTO where login=? and password=?");
		q.setString(0, login);
		q.setString(1, password);
		List list = q.list();
		UserDTO dto = null;
		if (list != null && list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

	public UserDTO findByPK(long pk) throws DataAccessException {
		UserDTO dto = null;
		Session session = sessionFactory.getCurrentSession();
		dto = (UserDTO) session.get(UserDTO.class, pk);
		return dto;
	}

	public List search(UserDTO dto) {

		return search(dto, 0, 0);
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(UserDTO.class);
		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				c.add(Restrictions.ilike("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				c.add(Restrictions.ilike("lastName", dto.getLastName() + "%"));
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				c.add(Restrictions.ilike("login", dto.getLogin() + "%"));
			}
			if (dto.getPassword() != null && dto.getPassword().length() > 0) {
				c.add(Restrictions.ilike("password", dto.getPassword() + "%"));
			}
			
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			c.setFirstResult(pageNo);
			c.setMaxResults(pageSize);
		}
		List list = c.list();
		return list;
	}

}
