package task1area;

import java.util.Scanner;

public class RectArea extends AreaQuadrilateral {

	Scanner sc = new Scanner(System.in);
	@Override
	public void areaQuad() {
		System.out.println("Enter length of rectangle : ");
		int length = sc.nextInt();
		System.out.println("Enter breadth of rectangle : ");
		int breadth = sc.nextInt();
		
		System.out.println(length*breadth);
		
	}
}
