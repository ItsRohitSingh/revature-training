package task1_exceptional_handling;

public class BusinessValidation {

	public boolean isValidPan(String pan) throws InvalidPANException {

		if (pan != null && pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
			return true;
		} else {
			throw new InvalidPANException("Entered PAN " + pan + " is INVALID");
		}
	}

	public boolean isValidDL(String dl) throws InvalidDLException {

		if (dl != null && dl.matches("[A-Z]{2}-[0-9]{13}")) {
			return true;
		} else {
			throw new InvalidDLException("Entered DL " + dl + " is INVALID");
		}
	}

	public boolean isValidEmail(String email) throws InvalidEmailException {
		if (email != null && email.matches("^(.+)@(.+)$")) {
			return true;
		} else {
			throw new InvalidDLException("Entered Email " + email + " is INVALID");
		}

	}

	public boolean isValidAadhaar(String aadhaar) throws InvalidAadhaarException {
		if (aadhaar != null && aadhaar.matches("[0-9]{12}")) {
			return true;
		} else {
			throw new InvalidAadhaarException("Entered Aadhaar " + aadhaar + " is INVALID");
		}

	}
}
