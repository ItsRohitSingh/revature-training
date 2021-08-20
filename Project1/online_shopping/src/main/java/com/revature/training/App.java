package com.revature.training;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

public class App {
	private static Logger log = Logger.getLogger(App.class);
	
	public static void startApp() {
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		
		do {
		log.info("\n\n# # # W E L C O M E   T O   T H E   C R E A T I N G   C O M M E R C E   A P P # # #");
		log.info("===============================================================================\n");
		
		log.info("1. Login as Customer");
		log.info("2. Login as Employee");
		log.info("3. Register as Customer");
		log.info("4. Read about this App here");
		log.info("5. Read about the Developer here");
		log.info("\n9. E X I T");
		
		log.info("\n\nChoose an option : ");
		
		try {
		option = Integer.parseInt(scanner.nextLine());
		} catch(NumberFormatException e) {
			log.warn(e.getMessage());
			continue;
		}
		
		switch(option) {
		case 1: // L O G I N   A S   A   C U S T O M E R
			LoginCustomer loginCustomer = new LoginCustomer();
			loginCustomer.loginCustomer();
			break;
		case 2: // L O G I N   A S   A N   E M P L O Y E E
			LoginEmployee loginEmployee = new LoginEmployee();
			loginEmployee.loginEmployee();
			break;
		case 3: // R E G I S T E R   A S   A   C U S T O M E R
			RegisterCustomer registerCustomer = new RegisterCustomer();
			registerCustomer.registerCustomer();
			break;
		case 4: // A B O U T   T H I S   A P P
			AboutThisApp aboutThisApp = new AboutThisApp();
			aboutThisApp.aboutApp();
			break;
		case 5: // A B O U T   T H E   D E V E L O P E R
			AboutTheDev aboutTheDev = new AboutTheDev();
			aboutTheDev.aboutDev();
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
		} while((option!=9));
	}
}
