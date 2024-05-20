package in.com.ioc;

import org.springframework.beans.factory.annotation.Value;

public class Inventory {
	@Value(value = "100")
	double stok;

	public double getStok() {
		return stok;
	}

	public void setStok(double stok) {
		this.stok = stok;
	}
	
	public double sold(double qty) {
		stok -= qty;
		return stok;
		
	}
}
