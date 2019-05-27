package myTrial;

import java.util.UUID;

public class Execution1 {

	public static void main(String[] args) {
		int[] x = { 11, 10, 10, 5, 10, 15, 20, 10, 7, 11 };
		System.out.println(foo(x, 8, 18, 3, 6));
		System.out.println(foo(x, 10, 20, 0, 9));
		System.out.println(foo(x, 8, 18, 6, 3));
		System.out.println(foo(x, 20, 10, 0, 9));
		System.out.println(foo(x, 6, 7, 8, 8));
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

	private static int foo(int[] x, int a, int b, int i, int j) {
		int k = j;
		int ct = 0;
		while (k > i - 1) {
			if (x[k] <= b && !(x[k] <= a)) {
				ct++;
			}
			k--;
		}
		return ct;
	}
}
