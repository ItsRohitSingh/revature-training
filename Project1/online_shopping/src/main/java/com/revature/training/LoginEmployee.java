package com.revature.training;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Products;
import com.revature.training.service.CustomerService;
import com.revature.training.service.ProductService;
import com.revature.training.service.impl.CustomerServiceImpl;
import com.revature.training.service.impl.ProductServiceImpl;

public class LoginEmployee {
	private static Logger log = Logger.getLogger(Main.class);

	public void loginEmployee() {
		Scanner scanner = new Scanner(System.in);
		log.info("Enter your Email Id : ");
		String emailId = scanner.nextLine();
		log.info("Enter your Password : ");
		String password = scanner.nextLine();

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
				case 1: 
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
				case 2:
					break;
				case 3:
					break;
				case 4:
					App app = new App();
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

	}
}
