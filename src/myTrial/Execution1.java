package myTrial;

import java.util.UUID;

public class Execution1 {

	public static void main(String[] args) {
		String str = "HOMETYPE.01";
		System.out.println(str.split("\\.")[1]);
		String[] col = "avb".split("\\.");
		System.out.println(col.length);

		System.out.println("-----------");

		int[] arr = new int[] {};
		System.out.println(arr.length);

		System.out.println("-----------");

		System.out.println(UUID.fromString(null));
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

}
