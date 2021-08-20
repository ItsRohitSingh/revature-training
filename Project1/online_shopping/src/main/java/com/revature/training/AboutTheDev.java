package com.revature.training;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class AboutTheDev {

	private static Logger log = Logger.getLogger(AboutTheDev.class);
	Scanner scanner = new Scanner(System.in);
	
	public void aboutDev() {
		log.info("\nW E L C O M E   T O   T H E   A B O U T   D E V   S E C T I O N !");
		log.info("=================================================================\n");
		log.info("My name is ROHIT SINGH. I am currently working as a Software \r\n"
				+"Engineer Trainee at Revature India. I have completed my graduation \r\n"
				+ "recently in 2020, from HMR Institute of Technology and Management \r\n"
				+"affiliated to Guru Gobind Singh Indraprastha University in New Delhi.\r\n"
				+"My specialization was Electronics and Communication Engineering (ECE).\r\n"
				+"I have an aggregate of 7.87 CGPA which points to 78.7% overall during \r\n"
				+"my B.Tech.\r\n");
		log.info("To know more about me and my works, you can connect with me on :-");
		log.info("GitHub   : https://github.com/ItsRohitSingh");
		log.info("LinkedIn : https://www.linkedin.com/in/rsrohitsingh");
	}
}
