package com.revature.training;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Cart;
import com.revature.training.model.Products;
import com.revature.training.service.CartService;
import com.revature.training.service.OrderService;
import com.revature.training.service.ProductService;
import com.revature.training.service.impl.CartServiceImpl;
import com.revature.training.service.impl.OrderServiceImpl;
import com.revature.training.service.impl.ProductServiceImpl;

public class SearchProducts {

	private static Logger log = Logger.getLogger(SearchProducts.class);
	Scanner scanner = new Scanner(System.in);

	public void searchProducts(int customerId) {
		int option = 0;
		do {
			log.info("\nW E L C O M E   T O   S E A R C H   P R O D U C T S   S E C T I O N !");
			log.info("=======================================================================\n");
			log.info("1. By Name");
			log.info("2. By Manufacturer Name");
			log.info("3. View Cart");
			log.info("4. Previous Menu");
			log.info("5. Logout");
			log.info("9. Exit");

			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				log.warn(e.getMessage());
				continue;
			}

			switch (option) {
			case 1: // S E A R C H   P R O D U C T S   B Y   P R O D U C T   N A M E
				log.info("Enter product name to get details");
				String name = scanner.nextLine();
				try {
					ProductService productService = new ProductServiceImpl();

					List<Products> productList = productService.showProductByName(name);

					if (productList != null && productList.size() > 0) {
						log.info("L I S T I N G   P R O D U C T S   B Y   N A M E");
						log.info("===============================================\n");
						for (Products product : productList) {
							log.info(product); // L I S T I N G   P R O D U C T S   B Y   N A M E
						}
						log.info("\n");

						log.info("Do you wish to add a product to cart (Y|N) : ");
						char order = scanner.nextLine().charAt(0);
						order = Character.toUpperCase(order);
						if (order == 'Y') {
							AddToCart addToCart = new AddToCart();
							addToCart.addToCart(customerId);
						} else if (order == 'N') {
							log.info("\nG O I N G   B A C K   T O   P R E V I O U S   M E N U !");
							log.info("-------------------------------------------------------\n");
						} else {
							log.warn("Please input correct value (Y|N).");
						}
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				break;
			case 2: // S E A R C H   P R O D U C T S   B Y   P R O D U C T   M A N U F A C T U R E R   N A M E
				log.info("Enter product name to get details");
				String manufacturer = scanner.nextLine();
				try {
					ProductService productService = new ProductServiceImpl();

					List<Products> productList = productService.showProductByManufacturer(manufacturer);

					if (productList != null && productList.size() > 0) {
						log.info("L I S T I N G   P R O D U C T S   B Y   M A N U F A C T U R E R");
						log.info("===============================================================\n");
						for (Products product : productList) {
							log.info(product); // L I S T I N G   P R O D U C T S   B Y   M A N U F A C T U R E R   N A M E
						}
						log.info("\n");

						log.info("Do you wish to add a product to cart (Y|N) : ");
						char order = scanner.nextLine().charAt(0);
						order = Character.toUpperCase(order);
						if (order == 'Y') {
							AddToCart addToCart = new AddToCart();
							addToCart.addToCart(customerId);
						} else if (order == 'N') {
							log.info("\nG O I N G   B A C K   T O   P R E V I O U S   M E N U !");
							log.info("-------------------------------------------------------\n");
						} else {
							log.warn("Please input correct value (Y|N).");
						}
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				break;
			case 3: // V I E W   C A R T   A N D   P L A C E   O R D E R
				CartService cartService = new CartServiceImpl();
				OrderService orderService = new OrderServiceImpl();
				try {
					List<Cart> cartList = cartService.viewCartByCustomer(customerId);
					if(cartList != null && cartList.size() > 0) {
						log.info("\nW E L C O M E   T O   Y O U R   C A R T !");
						log.info("=========================================\n");
						for(Cart cart : cartList) {
							log.info(cart); // P R I N T I N G   T H E   C A R T
							int productId = cart.getCartProductId();
							int quantityPurchased = cart.getQuantity();
							int checkUpdate = orderService.updateQuantityProduct(productId, quantityPurchased);
						}
						log.info("\nDo you want to place order for all items? (Y|N) : ");
						char order = scanner.nextLine().charAt(0);
						order = Character.toUpperCase(order);
						if (order == 'Y') { // P L A C E   T H E   O R D E R
							
							int totalAdd = orderService.addOrder(customerId);
							int checkDelete = orderService.deleteAllFromCart(customerId);
							
							log.info("Order has been placed for "+totalAdd+" products. Check 'View Orders' section for more details.");
						} else if (order == 'N') {
							log.info("\nG O I N G   B A C K   T O   P R E V I O U S   M E N U !");
							log.info("-------------------------------------------------------\n");
						} else {
							log.warn("Please input correct value (Y|N).");
						}
					}
					else {
						log.info("Your Cart is empty. Please add products to view them in your Cart.");
					}
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					log.warn(e.getMessage());
				}
				break;
			case 4: // G O   B A C K   T O   T H E   P R E V I O U S   M E N U
				
				break;
			case 5: // L O G O U T
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

			if (option == 4) { // I F   G O I N G   B A C K   T O   P R E V I O U S   M E N U
				break;
			}
		} while (option != 9);
	}
}
