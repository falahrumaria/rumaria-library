package javabrains.lambda_basics.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

  public static void main(String[] args) {
    int[] someNumbers = {1, 2, 3, 4};
    int key = 0;

    process(someNumbers, key, wrapper((x, y) -> System.out.println(x / y)));
  }

  private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
    for (int i : someNumbers) {
      consumer.accept(i, key);
    }
  }

  private static BiConsumer<Integer, Integer> wrapper(BiConsumer<Integer, Integer> consumer) {
    return (v, k) -> {
      try {
        consumer.accept(v, k);
      } catch (ArithmeticException e) {
        System.out.println("Exception caught in wrapper method");
      }
    };
  }
}
