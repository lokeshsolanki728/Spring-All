package in.com.autoWire.byName;

public class UserService {
	
	UserDao dao;
	public void setUserDao(UserDao dao) {
		this.dao=dao;
	}
	public void testAdd() {
		dao.add();
	}
}
