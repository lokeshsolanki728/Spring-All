package in.com.service;

import java.util.List;
import in.com.dto.UserDTO;

public interface UserServiceInt {
	public long add(UserDTO dto);

	public void update(UserDTO dto);

	public void delete(long id);

	public UserDTO findByLogin(String login);

	public UserDTO auth(String login, String password);

	public UserDTO findByPK(long pk);

	public List search(UserDTO dto);

	public List search(UserDTO dto, int pageNo, int pageSize);
}
