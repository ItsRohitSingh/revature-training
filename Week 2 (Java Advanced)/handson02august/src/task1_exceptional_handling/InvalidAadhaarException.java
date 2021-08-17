package task1_exceptional_handling;

import java.util.InputMismatchException;

public class InvalidAadhaarException extends InputMismatchException {

	public InvalidAadhaarException() {
		
	}
	
	public InvalidAadhaarException(String message) {
		super(message);
	}
}
