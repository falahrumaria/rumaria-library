package rumaria.library;

import java.util.LinkedList;
import java.util.Queue;

/**
 * fibonacci sequence 0, 1, 1, 2, 3, 5, 8, 13, ...
 *
 * @author rumaria
 */
public class FibonacciSequence {

  public static void main(String[] args) {
    print3();
  }

  /**
   * Print fibonacci using array. Fill up the array first and then looping it to print
   *
   * @param args
   */
  public static void print1() {
    int length = 50;
    long[] fibo = new long[length];
    fibo[0] = 0;
    fibo[1] = 1;
    for (int i = 2; i < length; i++) {
      fibo[i] = fibo[i - 1] + fibo[i - 2];
    }
    for (int i = 0; i < length; i++) {
      System.out.println(i + 1 + ". " + fibo[i]);
    }
  }

  /**
   * Print fibonacci using array of two
   *
   * @param args
   */
  public static void print2() {
    long[] fibo = {0, 1};
    int length = 50;
    System.out.println("1. " + fibo[0] + "\n" + "2. " + fibo[1]);
    for (int i = 3; i <= length; i++) {
      long nextNum = fibo[0] + fibo[1];
      System.out.println(i + ". " + nextNum);
      fibo[0] = fibo[1];
      fibo[1] = nextNum;
    }
  }

  /**
   * Print fibonacci using queue
   *
   * @param args
   */
  public static void print3() {
    int length = 50;
    Queue<Long> queue = new LinkedList<>();
    queue.add((long) 0);
    queue.add((long) 1);
    System.out.println(0 + "\n" + 1);
    for (int i = 2; i < length; i++) {
      long nextNum = queue.poll() + queue.peek();
      System.out.println(nextNum);
      queue.add(nextNum);
    }
  }
}
