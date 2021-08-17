package handson28july;

import java.math.*;
import java.util.Scanner;

public class HypotenuseRightTriangle {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter values of two sides of the Right-Angled triangle : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		double hypotenuse = calculateHypotenuse(a, b);
		System.out.println("The Hypotenuse of the given right-angled triangle is : "+ hypotenuse);
		
		
	}
	
	private static double calculateHypotenuse(int a, int b) {
		double hypo = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
		return hypo;
	}
}
