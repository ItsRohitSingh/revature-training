package task1_exceptional_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PresenterMain {

	public static void main(String[] args) throws InvalidPANException {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n\n\t\t##### M E N U #####\n");
		System.out.println("Enter the PAN Number : ");
		String pan = sc.nextLine();
		System.out.println("Enter the Driving License Number : ");
		String dl = sc.nextLine();
		System.out.println("Enter the Email ID : ");
		String email = sc.nextLine();
		System.out.println("Enter the Aadhaar Number : ");
		String aadhaar = sc.nextLine();
		
		BusinessValidation businessValidation = new BusinessValidation();
		
		boolean resPAN, resDL, resEmail, resAadhaar ;
		
		resPAN = businessValidation.isValidPan(pan);
		resDL = businessValidation.isValidDL(dl);
		resEmail = businessValidation.isValidEmail(email);
		resAadhaar = businessValidation.isValidAadhaar(aadhaar);
		
		if(resPAN) {
			System.out.println("PAN Validated");
		}
		else {
			System.out.println("PAN Invalid");
		}
		
		if(resDL) {
			System.out.println("DL Validated");
		}
		else {
			System.out.println("DL Invalid");
		}
		
		if(resEmail) {
			System.out.println("Email Validated");
		}
		else {
			System.out.println("Email Invalid");
		}
		
		if(resAadhaar) {
			System.out.println("Aadhaar Validated");
		}
		else {
			System.out.println("Aadhaar Invalid");
		}
		
		
	}
}
