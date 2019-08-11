package myTrial;

public class Solution1 {

    public static void main(String[] args) {
//        int[] nums = {0, 3, 0, 1, 1, -1, -5, -5, 3, -3, -3, 0};
        System.out.println(new StringBuilder().toString().equals(""));
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean exist = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    exist = false;
                    break;
                }
            }
            if (exist) {
                return i;
            }
        }
        return -1;
    }
}

