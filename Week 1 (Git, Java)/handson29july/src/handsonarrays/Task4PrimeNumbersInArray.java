package handsonarrays;

public class Task4PrimeNumbersInArray {

	public static int primemeOrNot(int N) {
		int num = N ;
		int flag = 1;
		for(int i=2; i<=N/2; i++) {
			if(N%i == 0) {
				flag = 0;
			}
		}
		
		if(flag == 1) {
			return 1;
		}
		else {
			return 0;
		}
		
	}

	public static void main(String[] args) {
		int arr[] = { 3, 5, 7, 9, 11 };
		int ans ;
		for (int i = 0; i < arr.length; i++) {
			ans = primemeOrNot(arr[i]);
			
			if(ans == 1) {
				System.out.print(arr[i] + " ");
			}
			
		}
	}
}
