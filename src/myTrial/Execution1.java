package myTrial;

import java.util.LinkedList;
import java.util.List;

public class Execution1 {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			if (list.get(i) == 3) {
				list.remove(i);
				i--;
			}
		}
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
