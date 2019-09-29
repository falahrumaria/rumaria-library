package rumaria.test.xtremax;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {
    public static void main(String[] args) {
        int[] arr = {40, 3, 5, 9, 13, 1};
        System.out.println(solution(arr));
    }

    public static boolean solution(int[] A) {
        if (checkSorted(A)) {
            System.out.println("langsung here");
            return true;
        }
        List<int[]> list = generateCombination(A.length, 2);
        for (int[] arrayOfIndex : list) {
            int bucket = A[arrayOfIndex[0]];
            A[arrayOfIndex[0]] = A[arrayOfIndex[1]];
            A[arrayOfIndex[1]] = bucket;
            if (checkSorted(A)) {
                System.out.println("ketemu kombinasi yg pas");
                return true;
            }
            bucket = A[arrayOfIndex[0]];
            A[arrayOfIndex[0]] = A[arrayOfIndex[1]];
            A[arrayOfIndex[1]] = bucket;
        }
        return false;
    }

    private static boolean checkSorted(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /*
     * from https://www.baeldung.com/java-combinations-algorithm
     * */
    private static List<int[]> generateCombination(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];

        // initialize with lowest lexicographic combination
        for (int i = 0; i < r; i++) {
            combination[i] = i;
        }

        while (combination[r - 1] < n) {
            combinations.add(combination.clone());

            // generate next combination in lexicographic order
            int t = r - 1;
            while (t != 0 && combination[t] == n - r + t) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < r; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }

        return combinations;
    }
}
