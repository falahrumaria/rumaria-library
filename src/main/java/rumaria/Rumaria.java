package rumaria;

import java.util.List;

public class Rumaria {

  public static void main(String[] args) {

    int[] myArr = new int[5];
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
