package handsonarrays;

public class Task1NthMax {
	public static void sorting(int arr[], int N) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					arr[i] = arr[j] + arr[i];
					arr[j] = arr[i] - arr[j];
					arr[i] = arr[i] - arr[j];
				}
			}
			//System.out.println(arr[i] + " ");

		}
		System.out.println(nMax(arr, N));
	}

	public static int nMax(int arr[], int N) {
		int count = 0 ;
		int ans=0;
		
		while(count<3) {
		for (int i=1; i<arr.length; i++) {
			if(arr[i] == arr[i-1]) {
				
			}
			else {
				count+=1;
			}
			if (count == N) {
				ans = arr[i-1] ;
			}
		}
		}
		return ans ;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int N = 2;
		sorting(arr, N);
	}
}
