package in.com.autoWire.notype;

public class UserService {
	private UserDao dao ;
	public void setUserDao(UserDao dao) {
		this.dao = dao;
	}
	public void testAdd() {
		dao.add();
	}
	
}
