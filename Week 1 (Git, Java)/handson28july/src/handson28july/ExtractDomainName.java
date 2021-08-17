package handson28july;

public class ExtractDomainName {
	public static void main(String[] args) {

		System.out.println(extractDomain("https://en.wikipedia.org/wiki/Main_Page"));
		System.out.println(extractDomain("https://google.com"));
	}

	public static String extractDomain(String url) {

		String domainName=null;
		String urlList[] = url.split("/");
		domainName = urlList[2];
		
		return domainName;
	}
}
