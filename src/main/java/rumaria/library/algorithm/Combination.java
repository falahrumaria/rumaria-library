package rumaria.library.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        List<int[]> list = generateCombination(3, 2);
        System.out.println(list.size());

    }

    /*
     * from https://www.baeldung.com/java-combinations-algorithm
     * */
    public static List<int[]> generateCombination(int n, int r) {
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
