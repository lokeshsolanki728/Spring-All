package in.com.getInstance;

public final class GetInstance1 {
	private static GetInstance1 instance;
	private GetInstance1() {
	}
	public static GetInstance1 getInstance() {
		if(instance==null) {
			instance = new GetInstance1();
		}
		return instance;
		
	}
	
}
