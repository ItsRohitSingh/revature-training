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
			
			if(result) {
				log.info("L O G - I N   S U C C E S S F U L L !");
				log.info("-------------------------------------\n");
				
				int customerId = customerService.getCustomerId(emailId);
				String firstName = customerService.fetchCustomerFirstName(customerId);
				firstName = firstName.toUpperCase().replaceAll(".(?!$)", "$0 ");
				log.info("W E L C O M E   "+firstName+" !");
			}
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage());
		}
		
		
	}
}
