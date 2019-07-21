package rumaria.library;

public class GCDandLCM {

	public static void main(String[] args) {
		int a = 6;
		int b = 9;
		int max = a > b ? a : b;
		int min = a == max ? b : a;
		int lcm; // least common multiple
		int gcd; // greatest commom divisor
		int multiplier = 2;
		a = max; // save max value for its multiplication

		while (max % min != 0) {
			max = multiplier * a;
			multiplier++;
		}

		lcm = max;
		gcd = a * min / lcm;

		System.out.println(lcm + "\n" + gcd);
	}

}
