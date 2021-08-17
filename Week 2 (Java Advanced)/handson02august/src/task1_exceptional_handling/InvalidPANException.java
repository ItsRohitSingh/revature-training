package task1_exceptional_handling;

import java.util.InputMismatchException;

public class InvalidPANException extends InputMismatchException {

	public InvalidPANException() {
		
	}
	
	public InvalidPANException(String message) {
		super(message);
	}
}
