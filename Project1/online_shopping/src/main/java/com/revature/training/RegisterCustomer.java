package com.revature.training;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.training.exception.BusinessException;
import com.revature.training.model.Customer;
import com.revature.training.service.CustomerService;
import com.revature.training.service.impl.CustomerServiceImpl;

public class RegisterCustomer {

	private static Logger log = Logger.getLogger(RegisterCustomer.class);
	Scanner scanner = new Scanner(System.in);
	
	public void registerCustomer() {
		
		log.info("\nW E L C O M E   T O   R E G I S T E R   C U S T O M E R   S E C T I O N !");
		log.info("=========================================================================\n");
		int checkRegister = 0;
		log.info("Please enter your First Name : ");
		String firstName = scanner.nextLine();
		log.info("Please enter your Last Name : ");
		String lastName = scanner.nextLine();
		log.info("Please enter your Email-Id : ");
		String emailId = scanner.nextLine();
		log.info("Please enter your Password : ");
		String password = scanner.nextLine();
		
		Customer customer = new Customer(firstName, lastName, emailId, password);
		
		CustomerService customerService = new CustomerServiceImpl();
		try {
			checkRegister = customerService.registerCustomer(customer);
		} catch (BusinessException e) {
			log.warn(e.getMessage());
		}
		
		if(checkRegister == 1) {
			firstName = firstName.toUpperCase().replaceAll(".(?!$)", "$0 ");
			log.info("\nC U S T O M E R   "+firstName+"   R E G I S T E R E D   S U C C E S S F U L L Y !");
			log.info("==========================================================================================\n");
		}
		else {
			log.warn("\nS O M E   E R R O R   O C C U R R E D !   C U S T O M E R   N O T   R E G I S T E R E D !");
			log.warn("=========================================================================================\n");
		}
	}
}
