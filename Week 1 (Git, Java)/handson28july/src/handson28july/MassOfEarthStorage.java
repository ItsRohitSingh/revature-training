package handson28july;

import java.text.DecimalFormat;

public class MassOfEarthStorage {

	public static void main(String[] args) {
		
		DecimalFormat dc = new DecimalFormat();
		
		double massOfEarth = 5.972e24d;
		System.out.println(dc.format(massOfEarth));
	}
}
