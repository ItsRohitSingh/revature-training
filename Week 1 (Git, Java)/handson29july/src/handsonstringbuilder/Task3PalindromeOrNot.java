package handsonstringbuilder;

public class Task3PalindromeOrNot {

	public static String PalindromeOrNot(String inp) {

		String arr[] = inp.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			StringBuilder sb1 = new StringBuilder(arr[i]);
			sb1.reverse();
			sb.append(sb1.toString()).append(" ");
		}

		return sb.toString().trim();
	}

	public static void main(String[] args) {
		System.out.println(PalindromeOrNot("hello my name is rohit"));
	}
}
