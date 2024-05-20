package in.com.bean;

public class UserBean {
	private String name;
	private String login;
	private String pass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	UserBean() {
	}

	@Override
	public String toString() {
		return "name=" + name + ", login=" + login + ", pass=" + pass;
	}

}
