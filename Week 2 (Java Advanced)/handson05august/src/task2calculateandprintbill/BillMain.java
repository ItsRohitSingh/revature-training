package task2calculateandprintbill;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BillMain {

	public static void main(String[] args) {
		int i = 1;
		List<Bill> billList = new ArrayList<>();
		billList.add(new Bill(i++, "Bag\t", 2549f, 1));
		billList.add(new Bill(i++, "Bottle\t", 399.00f, 3));
		billList.add(new Bill(i++, "Chair\t", 500f, 6));
		billList.add(new Bill(i++, "Mobile Phone", 10000f, 1));
		billList.add(new Bill(i++, "Telivision", 30000f, 1));
		billList.add(new Bill(i++, "Umbrella", 200.50f, 2));

		// double minCost = billList.stream().filter(e ->
		// e.getProviderName().equals("Xyz Travels")).map(e -> e.getCost())
//				.reduce(Double.MAX_VALUE, (a, b) -> a < b ? a : b);

//		System.out.println("The minimum cost of Xyz Travels is : " + minCost);


		
		BillMain bm = new BillMain();
		bm.printBill(billList);
		
	}
	
	Bill bill = new Bill();
	
	public void printBill(List<Bill> billList) {
		System.out.println("--------------------- W E L C O M E ---------------------");
		System.out.println("------------ S U P E R M A R K E T   B I L L ------------");
		System.out.println("---------------------------------------------------------");
		System.out.println("#\tName\t\tPrice\t\tQty.\tTotal");
		System.out.println("---------------------------------------------------------");
		int i=1;
		for(Bill b: billList) {
			System.out.println(b);
		}
		System.out.println("---------------------------------------------------------");
		Double totalBill = billList.stream().map(e -> e.getPrice()*e.getQuantity()).reduce(0.0, (sum, bill) -> sum+bill);
		
		System.out.println("Total\t\t\t\t\t\t"+totalBill);
		System.out.println("GST@5%\t\t\t\t\t\t"+totalBill*0.05);
		System.out.println("---------------------------------------------------------");
		System.out.println("Final Amount\t\t\t\t\t"+totalBill*1.05);
		System.out.println("---------------------------------------------------------");
		System.out.println("Amount Payable (After Rounding-off)\t\t"+Math.round(totalBill*1.05));
		System.out.println("---------------------------------------------------------");
		System.out.println("--- T H A N K   Y O U   F O R   P U R C H A S I N G ! ---");
		System.out.println("---------------------------------------------------------");
	}

}
