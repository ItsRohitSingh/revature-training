package handsonarrays;

public class Task3PalindromeInArray {

	public static int palindromeOrNot(int N) {
		int num = N ;
		int rev=0;
		while(num != 0) {
		    
		      int digit = num % 10;
		      rev = rev * 10 + digit;

		      
		      num /= 10;
		}
		
		if(N == rev) {
			return 1;
		}
		else {
			return 0;
		}
		
	}

	public static void main(String[] args) {
		int arr[] = { 101, 232, 627, 1221, 341 };
		int ans ;
		for (int i = 0; i < arr.length; i++) {
			ans = palindromeOrNot(arr[i]);
			
			if(ans == 1) {
				System.out.print(arr[i] + " ");
			}
			
		}
	}
}
