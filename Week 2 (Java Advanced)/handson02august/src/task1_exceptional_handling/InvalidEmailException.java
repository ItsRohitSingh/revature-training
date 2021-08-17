package task1_exceptional_handling;

import java.util.InputMismatchException;

public class InvalidEmailException extends InputMismatchException {

	public InvalidEmailException() {
		
	}
	
	public InvalidEmailException(String message) {
		super(message);
	}
}
