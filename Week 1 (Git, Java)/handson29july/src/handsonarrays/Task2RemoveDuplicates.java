package handsonarrays;

public class Task2RemoveDuplicates {
	public static void sorting(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					arr[i] = arr[j] + arr[i];
					arr[j] = arr[i] - arr[j];
					arr[i] = arr[i] - arr[j];
				}
			}
			//System.out.println(arr[i] + " ");

		}
		nMax(arr);
	}

	public static void nMax(int arr[]) {
		System.out.print(arr[0] + " ");
		for(int i=1; i<arr.length; i++) {
			if(arr[i] != arr[i-1]) {
				System.out.print(arr[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 2, 5 };
		sorting(arr);
	}
}
