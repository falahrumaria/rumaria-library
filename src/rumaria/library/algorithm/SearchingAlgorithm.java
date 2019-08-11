package rumaria.library.algorithm;

public class SearchingAlgorithm {

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 29};
        System.out.println(doBinarySearch(array, 2));
        System.out.println(doBinarySearch(array, 4));
        System.out.println(doBinarySearch(array, 6));
        System.out.println(doBinarySearch(array, 8));
        System.out.println(doBinarySearch(array, 11));
        System.out.println(doBinarySearch(array, 12));
        System.out.println(doBinarySearch(array, 14));
        System.out.println(doBinarySearch(array, 16));
        System.out.println(doBinarySearch(array, 18));
        System.out.println(doBinarySearch(array, 29));
    }

    /**
     * the binary search
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
     *
     * @param nums
     * @param target
     * @return the index at where the target is found or where the target should be
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
}
