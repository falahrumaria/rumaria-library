package rumaria.library;

public class MatrixSpiral {

	public static void main(String[] args) {
		int n = 3;
		int[][] element = new int[n][n];

		// for n = 4
		// 1 2 3 4
		// 12 13 14 5
		// 11 16 15 6
		// 10 9 8 7

		int totalLayer = (n + 1) / 2; // for n = 4, total layer : 2
		int max = 4 * (n - 1); // max value

		// Assigning matrix value
		for (int layer = 0; layer < totalLayer; layer++) {
			for (int i = layer; i < layer + n - 2 * layer; i++) // n-2*layer : length for each layer
			{
				for (int j = layer; j < layer + n - 2 * layer; j++) {
					if (layer == 0) {
						if (i == layer) {
							element[i][j] = j + 1;
						} else if (i == layer + 1 && j == layer) {
							element[i][j] = max;
						} else if (i > layer + 1 && j == layer) {
							element[i][j] = element[i - 1][j] - 1;
						} else if (i > layer && j == n - 2 * layer - 1) {
							element[i][j] = element[i - 1][j] + 1;
						} else if (i == n - 2 * layer - 1 && j > layer) {
							element[i][j] = element[i][j - 1] - 1;
						}
					} else {
						if (i == layer) {
							element[i][j] = element[i][j - 1] + 1;
						} else if (i == layer + 1 && j == layer) {
							max += 4 * (n - 2 * layer - 1);
							element[i][j] = max;
						} else if (i > layer + 1 && j == layer) {
							element[i][j] = element[i - 1][j] - 1;
						} else if (i > layer && j == layer + n - 2 * layer - 1) {
							element[i][j] = element[i - 1][j] + 1;
						} else if (i == layer + n - 2 * layer - 1 && j > layer) {
							element[i][j] = element[i][j - 1] - 1;
						}
					}
				}
			}
		}

		// Print the matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(element[i][j]);
			}
			System.out.println();
		}

	}

}
