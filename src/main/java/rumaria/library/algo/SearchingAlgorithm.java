package rumaria.library.algo;

public class SearchingAlgorithm {

  public static void main(String[] args) {

  }

  /**
   * the binary search
   *
   * @param array
   * @param target
   * @return the index at where the target is found or -1 when it is not found
   */
  public static int doBinarySearch(int[] array, int target) {
    int baseIndex = 0;
    int upperBoundIndex = array.length;
    int midIndex = (baseIndex + upperBoundIndex) / 2;
    while (baseIndex < midIndex) {
      if (target < array[midIndex]) {
        upperBoundIndex = midIndex;
      } else {
        baseIndex = midIndex;
      }
      midIndex = (baseIndex + upperBoundIndex) / 2;
    }
    if (target == array[midIndex]) {
      return midIndex;
    }
    return -1;
  }

  /**
   * @param nums
   * @param target
   * @return the index at where the target is found or where the target should be when it is not
   * found
   */
  public static int searchInsert(int[] nums, int target) {
    int baseIndex = 0;
    int upperBoundIndex = nums.length;
    int midIndex = (baseIndex + upperBoundIndex) / 2;
    while (baseIndex < midIndex) {
      if (target < nums[midIndex]) {
        upperBoundIndex = midIndex;
      } else {
        baseIndex = midIndex;
      }
      midIndex = (baseIndex + upperBoundIndex) / 2;
    }
    if (target > nums[midIndex]) {
      return midIndex + 1;
    }
    return midIndex;
  }

  /**
   * binary search with recursive implementation
   *
   * @param key
   * @param a
   * @param lo
   * @param hi
   * @return the index at where the target is found or -1 when it is not found
   */
  public static int rank(int key, int[] a, int lo, int hi) {
    if (lo > hi) {
      return -1;
    }
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) {
      return rank(key, a, lo, mid - 1);
    } else if (key > a[mid]) {
      return rank(key, a, mid + 1, hi);
    } else {
      return mid;
    }
  }

  /**
   * binary search with recursive implementation
   *
   * @param key
   * @param a
   * @param lo
   * @param hi
   * @return the index at where the target is found or -1 when it is not found
   */
  public static int rank1(int key, int[] a, int lo, int hi) {
    if (lo > hi) {
      return -1;
    }
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) {
      return rank(key, a, lo, mid - 1);
    } else if (key > a[mid]) {
      return rank(key, a, mid + 1, hi);
    } else {
      return mid;
    }
  }

  /**
   * binary search with recursive implementation
   *
   * @param key
   * @param a
   * @param lo
   * @param hi
   * @return the index at where the target is found or -1 when it is not found
   */
  public static int rank2(int key, int[] a, int lo, int hi) {
    if (lo > hi) {
      return -1;
    }
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) {
      return rank(key, a, lo, mid - 1);
    } else if (key > a[mid]) {
      return rank(key, a, mid + 1, hi);
    } else {
      return mid;
    }
  }
}
