package task1area;

import java.util.Scanner;

public class SquareArea extends AreaQuadrilateral {

	Scanner sc = new Scanner(System.in);
	@Override
	public void areaQuad() {
		System.out.println("Enter side of square : ");
		int side = sc.nextInt();
		
		
		System.out.println(side*side);
		
	}
}
