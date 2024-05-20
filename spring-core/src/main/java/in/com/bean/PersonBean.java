package in.com.bean;

public class PersonBean {
	private String type;
	private String aadharNo;
	UserBean bean;
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAadharNo() {
		return aadharNo;
	}


	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}


	public UserBean getBean() {
		return bean;
	}


	public void setBean(UserBean bean) {
		this.bean = bean;
	}


	public PersonBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "PersonBean [type=" + type + ", aadharNo=" + aadharNo + ", bean=" + bean + "]";
	}
	
}
