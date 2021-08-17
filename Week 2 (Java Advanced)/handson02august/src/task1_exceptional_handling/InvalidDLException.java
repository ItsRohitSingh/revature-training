package task1_exceptional_handling;

import java.util.InputMismatchException;

public class InvalidDLException extends InputMismatchException {

	public InvalidDLException() {
		
	}
	
	public InvalidDLException(String message) {
		super(message);
	}
}
