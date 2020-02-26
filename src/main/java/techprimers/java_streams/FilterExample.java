package techprimers.java_streams;

import java.util.Arrays;
import java.util.List;

public class FilterExample {

  public static void main(String[] args) {
    List<String> names = Arrays.asList("Peter", "Sam", "greg", "Ryan");

    // this code
    for (String name : names) {
      if (!name.equals("Sam")) {
        System.out.println(name);
      }
    }

    // is equivalent to
    names.stream().filter(name -> !name.equals("Sam")).forEach(System.out::println);
  }
}
