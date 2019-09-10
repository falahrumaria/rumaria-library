package rumaria.library.algorithm;

public class SortingAlgorithm {

	public static void main(String[] args) {
		int[] numbers = new int[] { 3, 4, 0, 50, 7, 1, 9, 100 };
		printArray(doSelectionSort(numbers));

	}

	// sorting with selection sort algorithm
	private static int[] doSelectionSort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			int bestIndex = i;
			boolean swap = false;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[bestIndex]) {
					swap = true;
					bestIndex = j;
				}
			}
			if (swap) {
				int temp = numbers[i];
				numbers[i] = numbers[bestIndex];
				numbers[bestIndex] = temp;
			}
		}
		return numbers;
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}
