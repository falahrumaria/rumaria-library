package rumaria.test.xtremax;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

  public static void main(String[] args) {

  }

  public static int solution(int[] A, int[] B) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < A.length; i++) {
      set.add(A[i]);
    }
    while (!set.isEmpty()) {
      int leastNum = 3001;
      for (Integer num : set) {
        if (num < leastNum) {
          leastNum = num;
        }
      }
      for (int i = 0; i < B.length; i++) {
        if (leastNum == B[i]) {
          return leastNum;
        }
      }
      set.remove(leastNum);
    }
    return -1;
  }
}
