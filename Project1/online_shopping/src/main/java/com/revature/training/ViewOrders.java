package com.revature.training;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Order;
import com.revature.training.service.OrderService;
import com.revature.training.service.impl.OrderServiceImpl;

public class ViewOrders {

	private static Logger log = Logger.getLogger(ViewOrders.class);
	Scanner scanner = new Scanner(System.in);

	public void viewOrders() {
		log.info("\nW E L C O M E   T O   V I E W   O R D E R S   S E C T I O N !");
		log.info("=============================================================\n");
		int option = 0;
		do {
			log.info("1. All Orders");
			log.info("2. By Customer Id");
			log.info("3. Previous Menu");
			log.info("4. Logout");
			log.info("\n9. E X I T");

			option = Integer.parseInt(scanner.nextLine());

			switch (option) {
			case 1:
				OrderService orderService1 = new OrderServiceImpl();
				List<Order> orderList1;
				try {
					orderList1 = orderService1.viewAllOrders();

					if (orderList1 != null && orderList1.size() > 0) {
						log.info("\nW E L C O M E   T O   C U S T O M E R   O R D E R S!");
						log.info("======================================================\n");
						for (Order order : orderList1) {
							log.info(order);
						}
						
						log.info("\nWould you like to change order status to Shipped? (Y|N) : ");
						char order = scanner.nextLine().charAt(0);
						order = Character.toUpperCase(order);
						if (order == 'Y') {
							log.info("Please enter Order Id to mark as Shipped : ");
							int orderId = Integer.parseInt(scanner.nextLine());
							
							int checkUpdate = orderService1.updateOrderStatus(orderId, "Shipped");
							
							if(checkUpdate == 1) {
								log.info("\nOrder Id "+orderId+" has been marked as SHIPPED successfully.");
							}
							else {
								log.warn("\nInvalid Order Id "+orderId+". Please enter valid Order Id and try again.");
							}
						} else if (order == 'N') {
							log.info("\nG O I N G   B A C K   T O   P R E V I O U S   M E N U !");
							log.info("-------------------------------------------------------\n");
						} else {
							log.warn("Please input correct value (Y|N).");
						}
					}
					else {
						log.info("No Orders placed by this Customer yet.");
					}
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				log.info("Please enter Customer Id to view Orders : ");
				int customerId = Integer.parseInt(scanner.nextLine());
				OrderService orderService = new OrderServiceImpl();
				List<Order> orderList;
				try {
					orderList = orderService.viewOrderByCustomer(customerId);

					if (orderList != null && orderList.size() > 0) {
						log.info("\nW E L C O M E   T O   C U S T O M E R   O R D E R S!");
						log.info("======================================================\n");
						for (Order order : orderList) {
							log.info(order);
						}
						
						log.info("\nWould you like to change order status to Shipped? (Y|N) : ");
						char order = scanner.nextLine().charAt(0);
						order = Character.toUpperCase(order);
						if (order == 'Y') {
							log.info("Please enter Order Id to mark as Shipped : ");
							int orderId = Integer.parseInt(scanner.nextLine());
							
							int checkUpdate = orderService.updateOrderStatus(orderId, "Shipped");
							
							if(checkUpdate == 1) {
								log.info("\nOrder Id "+orderId+" has been marked as SHIPPED successfully.");
							}
							else {
								log.warn("\nInvalid Order Id "+orderId+". Please enter valid Order Id and try again.");
							}
						} else if (order == 'N') {
							log.info("\nG O I N G   B A C K   T O   P R E V I O U S   M E N U !");
							log.info("-------------------------------------------------------\n");
						} else {
							log.warn("Please input correct value (Y|N).");
						}
					}
					else {
						log.info("No Orders placed by this Customer yet.");
					}
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				// NOTHING HERE
				break;
			case 4:
				App app = new App();
				app.startApp();
				break;
			case 9:
				log.info("\nT H A N K   Y O U   F O R   V I S I T I N G   O U R   S T O R E !");
				log.info("-----------------------------------------------------------------\n");
				scanner.close();
				System.exit(0);
				break;
			default:
				log.info("Please enter a valid option!");
			}
			if (option == 3) {
				break;
			}
		} while (option != 9);
	}
}
