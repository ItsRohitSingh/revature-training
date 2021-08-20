package com.revature.training;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Products;
import com.revature.training.service.CustomerService;
import com.revature.training.service.ProductService;
import com.revature.training.service.impl.CustomerServiceImpl;
import com.revature.training.service.impl.ProductServiceImpl;

public class LoginEmployee {
	private static Logger log = Logger.getLogger(LoginEmployee.class);
	Scanner scanner = new Scanner(System.in);

	public void loginEmployee() {
		log.info("\nW E L C O M E   T O   L O G I N   E M P L O Y E E   S E C T I O N !");
		log.info("===================================================================\n");
		log.info("Enter your Email Id : ");
		String emailId = scanner.nextLine();
		log.info("Enter your Password : ");
		String password = scanner.nextLine();

		// H A R D C O D E D   C R E D E N T I A L S   F O R   E M P L O Y E E
		if (emailId.equals("rohit@onlineshopping.com") && password.equals("rohit")) { 
			log.info("L O G - I N   S U C C E S S F U L L !");
			log.info("-------------------------------------\n");
			int option = 0;
			do {
				log.info("W E L C O M E   R O H I T !");
				log.info("===========================\n");

				log.info("1. Add a Product");
				log.info("2. View Orders");
				log.info("3. View Customers");
				log.info("4. Logout");
				log.info("\n9. E X I T");
				log.info("\n\nChoose an option : ");
				
				try {
					option = Integer.parseInt(scanner.nextLine());
				} catch(NumberFormatException e) {
					log.warn(e.getMessage());
				}
				
				switch(option) {
				case 1: // A D D I N G   A   P R O D U C T
					try {
					log.info("Enter Product Name : ");
					String productName = scanner.nextLine();
					log.info("Enter Manufacturer Name : ");
					String manufacturer = scanner.nextLine();
					log.info("Enter Quantity : ");
					int quantity = Integer.parseInt(scanner.nextLine());
					log.info("Enter Price : ");
					int price = Integer.parseInt(scanner.nextLine());
					
					Products product = new Products(productName, manufacturer, quantity, price);
					
					ProductService productService = new ProductServiceImpl();
					
						int checkProduct = productService.addProduct(product);
					} catch (BusinessException e) {
						log.warn(e.getMessage());
					}
					break;
				case 2: // V I E W   O R D E R S
					ViewOrders viewOrders = new ViewOrders();
					viewOrders.viewOrders();
					break;
				case 3: // S E A R C H   C U S T O M E R S
					SearchCustomers searchCustomers = new SearchCustomers();
					searchCustomers.searchCustomers();
					break;
				case 4: // L O G - O U T
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
		else {
			log.warn("Incorrect EmailId or Password! Please try again.");
		}

	}
}
