package rumaria.library.algo;

import java.util.ArrayList;
import java.util.List;

public class Combination {

  /*
   * from https://www.baeldung.com/java-combinations-algorithm
   * generate combination of r elements from n elements
   * start from 0
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

  /*
   * from https://www.baeldung.com/java-combinations-algorithm
   * generate combination of r elements from n elements
   * start from 1
   * */
  public static List<int[]> generateCombination1(int n, int r) {
    List<int[]> combinations = new ArrayList<>();
    int[] combination = new int[r];

    // initialize with lowest lexicographic combination
    for (int i = 0; i < r; i++) {
      combination[i] = i + 1;
    }

    while (combination[r - 1] <= n) {
      combinations.add(combination.clone());

      // generate next combination in lexicographic order
      int t = r - 1;
      while (t != 0 && combination[t] - 1 == n - r + t) {
        t--;
      }
      combination[t]++;
      for (int i = t + 1; i < r; i++) {
        combination[i] = combination[i - 1] + 1;
      }
    }

    return combinations;
  }

  public List<List<Integer>> generateCombination2(int n, int r) {
    List<List<Integer>> combinations = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();

    // initialize with lowest lexicographic combination
    for (int i = 0; i < r; i++) {
      combination.add(i + 1);
    }

    while (combination.get(r - 1) <= n) {
      combinations.add(new ArrayList<>(combination));

      // generate next combination in lexicographic order
      int t = r - 1;
      while (t != 0 && combination.get(t) - 1 == n - r + t) {
        t--;
      }
      combination.set(t, combination.get(t) + 1);
      for (int i = t + 1; i < r; i++) {
        combination.set(i, combination.get(i - 1) + 1);
      }
    }

    return combinations;
  }
}
