package rumaria.library;

import java.util.ArrayList;
import java.util.List;

/**
 * example of matrix spiral
 * 1   2   3   4
 * 12  13  14   5
 * 11  16  15   6
 * 10   9   8   7
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int n = 3;

    }

    /**
     * generate spiral matrix starting from val 1
     * implementation with formula
     *
     * @param n, dimension of the spiral matrix
     * @return spiral matrix
     */
    public static int[][] generateMatrixV1(int n) {
        int[][] matrix = new int[n][n];
        int totalLayer = (n + 1) / 2; // for n = 4, total layer : 2
        int max = 4 * (n - 1); // max value
        // n-2*layer : length for each layer

        for (int layer = 0; layer < totalLayer; layer++) {
            for (int i = layer; i < layer + n - 2 * layer; i++) {
                for (int j = layer; j < layer + n - 2 * layer; j++) {
                    if (layer == 0) {
                        if (i == layer) {
                            matrix[i][j] = j + 1;
                        } else if (i == layer + 1 && j == layer) {
                            matrix[i][j] = max;
                        } else if (i > layer + 1 && j == layer) {
                            matrix[i][j] = matrix[i - 1][j] - 1;
                        } else if (i > layer && j == n - 2 * layer - 1) {
                            matrix[i][j] = matrix[i - 1][j] + 1;
                        } else if (i == n - 2 * layer - 1 && j > layer) {
                            matrix[i][j] = matrix[i][j - 1] - 1;
                        }
                    } else {
                        if (i == layer) {
                            matrix[i][j] = matrix[i][j - 1] + 1;
                        } else if (i == layer + 1 && j == layer) {
                            max += 4 * (n - 2 * layer - 1);
                            matrix[i][j] = max;
                        } else if (i > layer + 1 && j == layer) {
                            matrix[i][j] = matrix[i - 1][j] - 1;
                        } else if (i > layer && j == layer + n - 2 * layer - 1) {
                            matrix[i][j] = matrix[i - 1][j] + 1;
                        } else if (i == layer + n - 2 * layer - 1 && j > layer) {
                            matrix[i][j] = matrix[i][j - 1] - 1;
                        }
                    }
                }
            }
        }
        return matrix;
    }

    /**
     * generate spiral matrix starting from val 1
     * implementation with following the spiraling path of the matrix
     *
     * @param n, dimension of the spiral matrix
     * @return spiral matrix
     */
    public static int[][] generateMatrixV2(int n) {
        int[][] spiralMatrix = new int[n][n];
        int row = 0;
        int col = 0;
        int val = 0;
        while (row < n && col < n && spiralMatrix[row][col] == 0) {
            // kanan
            do {
                spiralMatrix[row][col] = ++val;
                col++;
            } while (col < n && spiralMatrix[row][col] == 0);
            col--;
            row++;

            // bawah
            while (row < n && spiralMatrix[row][col] == 0) {
                spiralMatrix[row][col] = ++val;
                row++;
            }
            row--;
            col--;

            // kiri
            while (col >= 0 && spiralMatrix[row][col] == 0) {
                spiralMatrix[row][col] = ++val;
                col--;
            }
            col++;
            row--;

            // atas
            while (row >= 0 && spiralMatrix[row][col] == 0) {
                spiralMatrix[row][col] = ++val;
                row--;
            }
            row++;
            col++;
        }
        return spiralMatrix;
    }

    /**
     * @param matrix m x n
     * @return list of integer (matrix value) in spiral order starting from left-upper most element
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = 0;
        int col = 0;
        List<Integer> list = new ArrayList<>();
        while (row < matrix.length && col < matrix[0].length && matrix[row][col] != Integer.MAX_VALUE) {
            // kanan
            do {
                list.add(matrix[row][col]);
                matrix[row][col] = Integer.MAX_VALUE;
                col++;
            } while (col < matrix[0].length && matrix[row][col] != Integer.MAX_VALUE);
            col--;
            row++;

            // bawah
            while (row < matrix.length && matrix[row][col] != Integer.MAX_VALUE) {
                list.add(matrix[row][col]);
                matrix[row][col] = Integer.MAX_VALUE;
                row++;
            }
            row--;
            col--;

            // kiri
            while (col >= 0 && matrix[row][col] != Integer.MAX_VALUE) {
                list.add(matrix[row][col]);
                matrix[row][col] = Integer.MAX_VALUE;
                col--;
            }
            col++;
            row--;

            // atas
            while (row >= 0 && matrix[row][col] != Integer.MAX_VALUE) {
                list.add(matrix[row][col]);
                matrix[row][col] = Integer.MAX_VALUE;
                row--;
            }
            row++;
            col++;
        }
        return list;
    }

    private static void printTheMatrix(int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
