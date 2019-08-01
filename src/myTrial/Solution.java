package myTrial;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {0, 3, 0, 1, 1, -1, -5, -5, 3, -3, -3, 0};
        System.out.println(-5 % 10);
        System.out.println(reverse(2147483647));
    }

    public static int reverse(int x) {
        boolean digitStarter = true;
        int currentDivRemainder = 0;
        StringBuilder sb = new StringBuilder();
        if (x < 0) {
            sb.append('-');
            x *= -1;
        }
        while (x > 0) {
            currentDivRemainder = x % 10;
            x /= 10;
            if (digitStarter && currentDivRemainder == 0) {
                continue;
            }
            digitStarter = false;
            sb.append(currentDivRemainder);
        }
        try {
            return Integer.valueOf(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> listChild = new ArrayList<>();
                        listChild.add(nums[i]);
                        listChild.add(nums[j]);
                        listChild.add(nums[k]);
                        if (!combinationExists(list, listChild)) {
                            list.add(listChild);
                        }
                    }
                }
            }
        }
        return list;
    }

    private static boolean combinationExists(List<List<Integer>> list, List<Integer> newListChild) {
        for (List<Integer> listChild : list) {
            if (!listIsUnique(listChild, newListChild)) {
                return true;
            }
        }
        return false;
    }

    private static boolean listIsUnique(List<Integer> listChild, List<Integer> newListChild) {
        for (Integer x : listChild) {
            if (!equalsOneOf(x, newListChild)) {
                return true;
            }
        }
        for (int x : newListChild) {
            if (!equalsOneOf(x, listChild)) {
                return true;
            }
        }
        return false;
    }

    private static boolean equalsOneOf(int x, List<Integer> newListChild) {
        for (int num : newListChild) {
            if (x == num) {
                return true;
            }
        }
        return false;
    }
}
