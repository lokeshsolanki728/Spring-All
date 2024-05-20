package in.com.ioc;

public class Order1 {
	private Inventory inventory;
	private Payment payment;
	
	//setter injections
	public void setInventory(Inventory inventory) {
		this.inventory=inventory;
	}
	//setter injections
	public void setPayment (Payment payment) {
		this.payment=payment;
	}
	
	public void bookTickets(int items) {
		int price=10;
		double totalAmount = price*items;
		double updatedBalance  = payment.makePayment(totalAmount);
		double updatedStock =inventory.sold(items);
		System.out.println("Tickets are booked");
		System.out.println("Total Amount Paid :"+totalAmount);
		System.out.println("Remaning amount is :"+updatedBalance);
		System.out.println("updated Stocs is "+updatedStock);
		
		
		
	}
}
