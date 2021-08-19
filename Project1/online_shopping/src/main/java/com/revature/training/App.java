package com.revature.training;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

public class App {
	private static Logger log = Logger.getLogger(Main.class);
	
	public static void startApp() {
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		
		do {
		log.info("\n\n# # # W E L C O M E   T O   T H E   O N L I N E   S H O P P I N G   A P P # # #\n");
		log.info("===============================================================================");
		
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
		case 1: LoginCustomer loginCustomer = new LoginCustomer();
			loginCustomer.loginCustomer();
			break;
		case 2: LoginEmployee loginEmployee = new LoginEmployee();
			loginEmployee.loginEmployee();
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 9:
			log.info("T H A N K   Y O U   F O R   V I S I T I N G   O U R   S T O R E !");
			scanner.close();
			System.exit(0);
			break;
		default:
			log.info("Please enter valid option!");
			
		}
		} while((option!=9));
	}
}
