package com.revature.training;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.training.exception.BusinessException;
import com.revature.training.service.CartService;
import com.revature.training.service.impl.CartServiceImpl;

public class AddToCart {

	private static Logger log = Logger.getLogger(AddToCart.class);
	Scanner scanner = new Scanner(System.in);

	public void addToCart(int customerId) {
		try {
			log.info("\nW E L C O M E   T O   A D D   T O   C A R T   P A G E");
			log.info("=====================================================\n");
			log.info("Please enter the Product Id to add to cart : ");
			int productId = Integer.parseInt(scanner.nextLine());
			log.info("Please enter the number of items you wish to add to cart : ");
			int quantity = Integer.parseInt(scanner.nextLine());

			CartService cartService = new CartServiceImpl();

			boolean isProductInCart = cartService.checkProductInCart(customerId, productId);

			if (isProductInCart == false) {
				int checkAddToCart = cartService.addToCart(customerId, productId, quantity);
				String productName = cartService.fetchProductName(productId);

				if (checkAddToCart == 1) {
					log.info(
							"You have added " + quantity + " item(s) of " + productName + " to the cart successfully.");
				} else {
					log.warn(productName + " not added to cart. Please try again!");
				}
			} 
			else {
				String productName = cartService.fetchProductName(productId);
				int quantityInCart = cartService.checkQuantityInCart(customerId, productId);
				log.info(quantityInCart+" item(s) of "+productName+" are already present in the Cart. Do you want to change the quantity instead? (Y|N) : ");
				char choice = scanner.nextLine().charAt(0);
				choice = Character.toUpperCase(choice);
				if (choice == 'Y') {
					log.info("Please enter new quantities : ");
					int newQuantity = Integer.parseInt(scanner.nextLine());
					int checkChangeQuantity = cartService.changeQuantity(customerId, productId, newQuantity);
					
					if(checkChangeQuantity == 2) {
						log.info("Quantities have been updated from "+quantityInCart+" to "+newQuantity+", for "+productName);
					}
					else {
						log.warn("Quantities not updated.");
					}
				} else if (choice == 'N') {
					log.info("\nG O I N G   B A C K   T O   P R E V I O U S   M E N U !");
					log.info("-------------------------------------------------------\n");
				} else {
					log.warn("Please input correct value (Y|N).");
				}
			}
		} catch (BusinessException e) {
			log.warn(e.getMessage());
		}
	}
}
