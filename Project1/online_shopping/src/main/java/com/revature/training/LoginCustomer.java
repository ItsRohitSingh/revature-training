package com.revature.training;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import com.revature.training.exception.BusinessException;
import com.revature.training.service.CustomerService;
import com.revature.training.service.impl.CustomerServiceImpl;

public class LoginCustomer {
	private static Logger log = Logger.getLogger(Main.class);

	public void loginCustomer() {
		Scanner scanner = new Scanner(System.in);
		log.info("Enter your Email Id : ");
		String emailId = scanner.nextLine();
		log.info("Enter your Password : ");
		String password = scanner.nextLine();

		CustomerService customerService = new CustomerServiceImpl();
		try {
			boolean result = customerService.checkLogin(emailId, password);

			if (result) {
				log.info("L O G - I N   S U C C E S S F U L L !");
				log.info("-------------------------------------\n");
				int option = 0;
				do {
					int customerId = customerService.getCustomerId(emailId);
					String firstName = customerService.fetchCustomerFirstName(customerId);
					firstName = firstName.toUpperCase().replaceAll(".(?!$)", "$0 ");
					log.info("W E L C O M E   " + firstName + " !");
					log.info("================================================");

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
					case 1: SearchProducts searchProducts = new SearchProducts();
						searchProducts.searchProducts();
						break;
					case 2:
						break;
					case 3: App app = new App();
						app.startApp();
						break;
					case 9:
						log.info("T H A N K   Y O U   F O R   V I S I T I N G   O U R   S T O R E !");
						scanner.close();
						System.exit(0);
						break;
					}
				} while (option != 9);
			}

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage());
		}

	}
}
