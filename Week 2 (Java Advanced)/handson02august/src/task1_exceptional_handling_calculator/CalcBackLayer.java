package task1_exceptional_handling_calculator;

public class CalcBackLayer {

	public static void add(int x, int y) {
		System.out.println(x + " + " + y + " = " + (x+y));
	}
	
	public static void sub(int x, int y) {
		System.out.println(x + " - " + y + " = " + (x-y));
	}
	
	public static void multiply(int x, int y) {
		System.out.println(x + " * " + y + " = " + (x*y));
	}
	
	public static void divide(int x, int y) {
		try {
			System.out.println(x + " / " + y + " = " + (x/y));
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println("Not Defined");
		}
	}
}
