package rumaria;

import java.time.LocalDate;
import java.util.List;

public class Rumaria {

    public static void main(String[] args) {
        String str = "my name is";
        final String substring = str.substring(0, 3);
        System.out.println(substring);
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.plusDays(1));
        System.out.println("gaya busana".matches(".[abc].. ......"));
    }

    public static void printNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println("\b\b");
    }

    public static void printListOfNumbers(List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            printNumbers(list.get(i));
        }
    }

    public static void printNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i) + ", ");
        }
        System.out.println("\b\b");
    }

}
