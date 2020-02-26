package rumaria.library;

public class PrimeNumber {

  public static void main(String[] args) {
    for (int i = 2; i <= 100; i++) {
      int root = (int) Math.sqrt(i);
      boolean isPrime = true;
      for (int j = 2; j <= root; j++) {
        if ((i % j == 0)) {
          System.out.println(i + " is not a prime number");
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        System.out.println(i + " is a prime number");
      }
    }
  }
}
