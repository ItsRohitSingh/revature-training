package task1area;

import java.util.Scanner;

public class TrapeziumArea extends AreaQuadrilateral {

	Scanner sc = new Scanner(System.in);
	@Override
	public void areaQuad() {
		System.out.println("Enter length 1 of trapezium : ");
		int a = sc.nextInt();
		System.out.println("Enter length 2 of trapezium : ");
		int b = sc.nextInt();
		System.out.println("Enter height of trapezium : ");
		int h = sc.nextInt();
		
		System.out.println((a+b)*h/2);
		
	}
}
