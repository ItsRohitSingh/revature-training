package task1_exceptional_handling_calculator;

import java.util.InputMismatchException;

public class InvalidInputException extends InputMismatchException {

	public InvalidInputException() {
		
	}
	
	public InvalidInputException(String message) {
		super(message);
	}
}
