package rumaria.library;

import java.util.LinkedList;
import java.util.Queue;

public class SortingAlgorithm {

	public static void main(String[] args) {
		int[] numbers = new int[] { 3, 4, 0, 50, 7, 1, 9, 100 };
		printArray(sort(numbers));
		System.out.println(">>>>>>>>>>> tes ovo 1 <<<<<<<<<<<<");
		int[] arr1 = { 1, 13, 20, 30, 90, 100 };
		int[] arr2 = { 11, 22 };
		printArray(sortTwoArrays(arr1, arr2));
	}

	// sorting with selection sort algorithm
	private static int[] sort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			int least = numbers[i];
			int position = i;
			boolean isSwitch = false;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < least) {
					isSwitch = true;
					least = numbers[j];
					position = j;
				}
			}
			if (isSwitch) {
				int temp = numbers[i];
				numbers[i] = least;
				numbers[position] = temp;
			}
		}
		return numbers;
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

	// tes ovo
	private static int[] sortTwoArrays(int[] arr1, int[] arr2) {
		int[] combinedArr = new int[arr1.length + arr2.length];
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		for (int i = 0; i < arr1.length; i++) {
			q1.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			q2.add(arr2[i]);
		}
		for (int i = 0; i < combinedArr.length; i++) {
			if (q1.isEmpty()) {
				combinedArr[i] = q2.poll();
			} else if (q2.isEmpty()) {
				combinedArr[i] = q1.poll();
			} else {
				combinedArr[i] = q1.peek() < q2.peek() ? q1.poll() : q2.poll();
			}
		}
		return combinedArr;
	}
}
