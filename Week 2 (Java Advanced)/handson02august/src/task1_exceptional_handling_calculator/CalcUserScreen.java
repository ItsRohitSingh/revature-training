package task1_exceptional_handling_calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcUserScreen {

	public static void main(String[] args) throws InvalidInputException {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n\n\n\t\t##### C A L C U L A T O R   M E N U #####");
			System.out.println("\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n\n9. Exit");
			System.out.println("\n\nPlease enter your choice : ");

			try {
				int choice = sc.nextInt();
				if (((choice >= 1) && (choice <= 4)) || (choice == 9)) {
					int a, b;
					CalcBackLayer cbl = new CalcBackLayer();
					switch (choice) {
					case 1:
						System.out.println("Enter the two numbers : ");
						a = sc.nextInt();
						b = sc.nextInt();
						cbl.add(a, b);
						break;
					case 2:
						System.out.println("Enter the two numbers : ");
						a = sc.nextInt();
						b = sc.nextInt();
						cbl.sub(a, b);
						break;
					case 3:
						System.out.println("Enter the two numbers : ");
						a = sc.nextInt();
						b = sc.nextInt();
						cbl.multiply(a, b);
						break;
					case 4:
						System.out.println("Enter the two numbers : ");
						a = sc.nextInt();
						b = sc.nextInt();
						cbl.divide(a, b);
						break;
					case 9:
						System.out.println("Thank you for using this app!!!");
						System.exit(0);
						break;
					}
				} else {
					throw new InvalidInputException("Invalid input given");
				}
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}

		}
	}
}
