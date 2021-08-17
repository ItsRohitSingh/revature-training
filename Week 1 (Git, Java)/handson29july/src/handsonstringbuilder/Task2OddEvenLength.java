package handsonstringbuilder;

public class Task2OddEvenLength {
	
	public static String OddEven(String inp) {
		
		String arr[] = inp.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			if(arr[i].length() %2 == 1) {
				int mid = (arr[i].length() + 1)/2 ;
				sb.append(arr[i].substring(0, mid-1)).append(Character.toUpperCase(arr[i].charAt(mid-1))).append(arr[i].substring(mid)).append(" ");
			}
			else {
				sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
			}
			
		}
		return sb.toString().trim();
	}
	
	public static void main(String[] args) {
		System.out.println(OddEven("hello my name is rohit"));
	}
}
