package handson28july;

public class SecureOrNotSecure {
	public static void main(String[] args) {

		if(extractDomain("https://en.wikipedia.org/wiki/Main_Page").equals("http:")) {
			System.out.println("Not Secure");
		}
		else {
			System.out.println("Secure");
		}
	}

	public static String extractDomain(String url) {

		String httpPart=null;
		String urlList[] = url.split("/");
		httpPart = urlList[0];
		
		return httpPart;
	}
}
