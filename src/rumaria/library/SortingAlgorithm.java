package rumaria.library;

public class SortingAlgorithm {

	public static void main(String[] args) {
		System.out.println("\n=========================================\n");
		int[] numbers = new int[] { 3, 4, 0, 50, 7, 1, 9, 100 };
		printArray(sort(numbers));
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
}
