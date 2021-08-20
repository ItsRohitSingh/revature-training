package com.revature.training;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Customer;
import com.revature.training.model.Products;
import com.revature.training.service.CustomerService;
import com.revature.training.service.ProductService;
import com.revature.training.service.impl.CustomerServiceImpl;
import com.revature.training.service.impl.ProductServiceImpl;

public class SearchCustomers {

	private static Logger log = Logger.getLogger(SearchCustomers.class);
	Scanner scanner = new Scanner(System.in);

	public void searchCustomers() {
		int option = 0;
		do {
			log.info("\nW E L C O M E   T O   S E A R C H   C U S T O M E R   S E C T I O N !");
			log.info("=====================================================================\n");
			log.info("1. By First Name");
			log.info("2. By Last Name");
			log.info("3. By Email-Id");
			log.info("4. By Order Id");
			log.info("5. Previous Menu");
			log.info("6. Logout");
			log.info("9. Exit");

			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				log.warn(e.getMessage());
				continue;
			}

			switch (option) {
			case 1:
				log.info("Enter first name to get details : ");
				String firstName = scanner.nextLine();
				try {
					CustomerService customerService = new CustomerServiceImpl();

					List<Customer> customerList = customerService.showCustomerByFirstName(firstName);

					if (customerList != null && customerList.size() > 0) {
						log.info("L I S T I N G   C U S T O M E R S   B Y   F I R S T   N A M E");
						log.info("=============================================================\n");
						for (Customer customer : customerList) {
							log.info(customer);
						}
						log.info("\n");
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				break;
			case 2:
				log.info("Enter last name to get details : ");
				String lastName = scanner.nextLine();
				try {
					CustomerService customerService = new CustomerServiceImpl();

					List<Customer> customerList = customerService.showCustomerByLastName(lastName);

					if (customerList != null && customerList.size() > 0) {
						log.info("L I S T I N G   C U S T O M E R S   B Y   L A S T   N A M E");
						log.info("===========================================================\n");
						for (Customer customer : customerList) {
							log.info(customer);
						}
						log.info("\n");
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				break;
			case 3:
				log.info("Enter Email-Id to get details : ");
				String emailId = scanner.nextLine();
				try {
					CustomerService customerService = new CustomerServiceImpl();

					List<Customer> customerList = customerService.showCustomerByEmail(emailId);

					if (customerList != null && customerList.size() > 0) {
						log.info("L I S T I N G   C U S T O M E R S   B Y   E M A I L - I D");
						log.info("=========================================================\n");
						for (Customer customer : customerList) {
							log.info(customer);
						}
						log.info("\n");
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				break;
			case 4:
				log.info("Enter Order-Id to get details : ");
				int orderId = Integer.parseInt(scanner.nextLine());
				try {
					CustomerService customerService = new CustomerServiceImpl();

					List<Customer> customerList = customerService.showCustomerByOrder(orderId);

					if (customerList != null && customerList.size() > 0) {
						log.info("L I S T I N G   C U S T O M E R S   B Y   O R D E R - I D");
						log.info("=========================================================\n");
						for (Customer customer : customerList) {
							log.info(customer);
						}
						log.info("\n");
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				break;
			case 5:
				// NO Command here (Previous Menu)
				break;
			case 6:
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

			if (option == 5) {
				break;
			}

		} while (option != 9);
	}
}
