package myTrial;

import java.util.LinkedList;
import java.util.List;

public class Execution1 {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(6);
		list.add(9);
		list.add(0);
		list.add(4, 5);
		printArray(list);
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

	private static void printArray(List<Integer> numbers) {
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
	}

}
