package com.revature.training;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;
import com.revature.training.model.Order;
import com.revature.training.service.CustomerService;
import com.revature.training.service.OrderService;
import com.revature.training.service.impl.CustomerServiceImpl;
import com.revature.training.service.impl.OrderServiceImpl;

public class LoginCustomer {
	private static Logger log = Logger.getLogger(LoginCustomer.class);
	Scanner scanner = new Scanner(System.in);

	public void loginCustomer() {
		log.info("\nW E L C O M E   T O   L O G I N   C U S T O M E R   S E C T I O N !");
		log.info("===================================================================\n");
		log.info("Enter your Email Id : ");
		String emailId = scanner.nextLine();
		log.info("Enter your Password : ");
		String password = scanner.nextLine();

		CustomerService customerService = new CustomerServiceImpl();
		try {
			boolean result = customerService.checkLogin(emailId, password); // C H E C K   L O G I N

			if (result) { // S U C C E S S F U L L   L O G I N
				log.info("\nL O G - I N   S U C C E S S F U L L !");
				log.info("-------------------------------------\n");
				int option = 0;
				do {
					int customerId = customerService.getCustomerId(emailId);
					String firstName = customerService.fetchCustomerFirstName(customerId);
					firstName = firstName.toUpperCase().replaceAll(".(?!$)", "$0 ");
					log.info("W E L C O M E   " + firstName + " !");
					log.info("==============================\n");

					log.info("1. Search Products");
					log.info("2. View Orders");
					log.info("3. Logout");
					log.info("\n9. E X I T");
					log.info("\n\nChoose an option : ");

					try {
						option = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						log.warn(e.getMessage());
						continue;
					}

					switch (option) {
					case 1: // S E A R C H   P R O D U C T S
						SearchProducts searchProducts = new SearchProducts();
						searchProducts.searchProducts(customerId);
						break;
					case 2: // V I E W   O R D E R S   A N D   M A R K   A S   D E L I V E R E D
						OrderService orderService = new OrderServiceImpl();
						List <Order> orderList = orderService.viewOrderByCustomer(customerId);
						if(orderList != null && orderList.size() > 0) {
							log.info("\nW E L C O M E   T O   Y O U R   O R D E R S!");
							log.info("==============================================\n");
							for(Order order : orderList) {
								log.info(order); // L I S T I N G   A L L   O R D E R S   B Y   L O G G E D - I N   C U S T O M E R
							}
							log.info("\nWould you like to change order status to Delivered? (Y|N) : ");
							char order = scanner.nextLine().charAt(0);
							order = Character.toUpperCase(order);
							if (order == 'Y') { // M A R K I N G   O R D E R   A S   D E L I V E R E D
								log.info("Please enter Order Id to mark as delivered : ");
								int orderId = Integer.parseInt(scanner.nextLine());
								
								int checkUpdate = orderService.updateOrderStatus(orderId, "Delivered");
								
								if(checkUpdate == 1) {
									log.info("\nOrder Id "+orderId+" has been marked as DELIVERED successfully.");
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
							log.info("You have not placed any order yet.");
						}
						break;
					case 3: // L O G - O U T
						App app = new App();
						app.startApp();
						break;
					case 9: // E X I T   T H E   A P P
						log.info("\nT H A N K   Y O U   F O R   V I S I T I N G   O U R   S T O R E !");
						log.info("-----------------------------------------------------------------\n");
						scanner.close();
						System.exit(0);
						break;
					default:
						log.info("Please enter a valid option!");
					}
				} while (option != 9);
			}

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage());
		}

	}
}
