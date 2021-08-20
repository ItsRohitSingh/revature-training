package com.revature.training;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class AboutThisApp {

	private static Logger log = Logger.getLogger(AboutThisApp.class);
	Scanner scanner = new Scanner(System.in);
	
	public void aboutApp() {
		log.info("\nW E L C O M E   T O   T H E   A B O U T   A P P   S E C T I O N !");
		log.info("=================================================================\n");
		log.info("This App is based on the online shopping app, we have provided various features \r\n" 
				+"related to the Customers and Employee. As a Customer, I can create an account on\r\n"
				+"this app and by logging-in, I can use this app to place orders and view products.\r\n"
				+"As an employee, I can access and add the products on this platform and I can     \r\n"
				+"change the status of any order and product.");
	}
}
