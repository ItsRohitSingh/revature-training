package handsonarrays;

public class Task5FirstLastDigitDifferent {

	public static int firstAndLast(int N) {
		boolean ans;
		StringBuilder sb = new StringBuilder(N);
		StringBuilder sb1 = new StringBuilder(N);
		String num = Integer.toString(N);
		sb.append(num.charAt(0));
		sb1.append(num.charAt(num.length() - 1));
		ans = sb.toString().equals(sb1.toString());
		if(ans == true) {
			return 0 ;
		}
		else {
			return 1 ;
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {101,22,344,699};
		int ans = 0;
		for(int i = 0; i<arr.length; i++) {
			ans = firstAndLast(arr[i]);
			if(ans == 1) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}
