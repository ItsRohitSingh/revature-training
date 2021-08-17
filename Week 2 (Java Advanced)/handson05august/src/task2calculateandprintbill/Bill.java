package task2calculateandprintbill;

//public class Bill implements Comparable<Bill> {

public class Bill {
	private int sNo;
	private String itemName;
	private double price;
	private int quantity;
	private float total;
	
	
	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Bill(int sNo, String itemName, float price, int quantity) {
		super();
		this.sNo = sNo;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.total = quantity*price;
	}
	
	public void printBill(int i, Bill billList) {
		System.out.println(sNo+"\t"+itemName+"\t"+price+"\t"+quantity+"\t"+total);
	}
	
	public Bill() {
		
	}

	@Override
	public String toString() {
		return sNo+"\t"+itemName+"\t"+price+"\t\t"+quantity+"\t"+total ;
	}
	
	
}
