package com.revature.training;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Products;
import com.revature.training.service.ProductService;
import com.revature.training.service.impl.ProductServiceImpl;

public class SearchProducts {

	private static Logger log = Logger.getLogger(Main.class);
	Scanner scanner = new Scanner(System.in);
	
	public void searchProducts() {
		int option=0;
		do {
		log.info("1. By Name");
		log.info("2. By Manufacturer Name");
		log.info("3. View Cart");
		log.info("4. Previous Menu");
		log.info("5. Logout");
		log.info("9. Exit");
		
		try {
			option = Integer.parseInt(scanner.nextLine());
		} catch(NumberFormatException e) {
			log.warn(e.getMessage());
			continue;
		}
		
		switch(option) {
		case 1: 
			log.info("Enter product name to get details");
			String name = scanner.nextLine();
			try {
				ProductService productService = new ProductServiceImpl();

				List<Products> productList = productService.showProductByName(name);
				
				if (productList != null && productList.size() > 0) {
					log.info("Total there are " + productList.size()
							+ " number of players playing for the team " + name.toUpperCase()
							+ " printing the players");
					log.info("L I S T I N G   P R O D U C T S   B Y   N A M E");
					log.info("===============================================\n");
					for (Products product : productList) {
						log.info(product);
					}
				}
			} catch (BusinessException e) {
				log.warn(e.getMessage());
			}
			break;
		case 2:
			log.info("Enter product name to get details");
			String manufacturer = scanner.nextLine();
			try {
				ProductService productService = new ProductServiceImpl();

				List<Products> productList = productService.showProductByManufacturer(manufacturer);
				
				if (productList != null && productList.size() > 0) {
					log.info("Total there are " + productList.size()
							+ " number of players playing for the team " + manufacturer.toUpperCase()
							+ " printing the players");
					log.info("L I S T I N G   P R O D U C T S   B Y   M A N U F A C T U R E R");
					log.info("===============================================================\n");
					for (Products product : productList) {
						log.info(product);
					}
				}
			} catch (BusinessException e) {
				log.warn(e.getMessage());
			}
			break;
		case 3:
			break;
		case 4:
			
			break;
		case 5:
			App app = new App();
			app.startApp();
			break;
		case 9:
			log.info("T H A N K   Y O U   F O R   V I S I T I N G   O U R   S T O R E !");
			scanner.close();
			System.exit(0);
			break;
		}
		
		if(option == 4) {
			break;
		}
		
		} while(option!=9);
	}
}
