package myTrial;

import java.util.*;

public class Execution1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.get(0));

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

}
