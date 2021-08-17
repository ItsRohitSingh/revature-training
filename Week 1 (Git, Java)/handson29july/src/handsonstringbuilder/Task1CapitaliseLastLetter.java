package handsonstringbuilder;

public class Task1CapitaliseLastLetter {
	
	public static String capitaliseLastLetter(String inp) {
		
		String arr[] = inp.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i].substring(0, arr[i].length() - 1)).append(Character.toUpperCase(arr[i].charAt(arr[i].length()-1))).append(" ");
		}
		return sb.toString().trim();
	}
	
	public static void main(String[] args) {
		System.out.println(capitaliseLastLetter("hello my name is rohit"));
	}
}
