package myTrial;

import java.math.BigDecimal;
import java.util.*;

public class Execution1 {

    public static void main(String[] args) {
        System.out.println(5 * 1.0 / 2);
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    private static void printArray(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }

    public boolean canJump(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0 && i < nums.length - 1 && !canPassZeroElement(i, nums)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean canPassZeroElement(int index, int[] nums) {
        int currentIndex = index - 1;
        while (currentIndex > -1) {
            if (nums[currentIndex] > nums[index] + index - currentIndex) {
                return true;
            }
            currentIndex--;
        }
        return false;
    }
}
