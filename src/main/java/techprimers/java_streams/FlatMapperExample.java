package techprimers.java_streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FlatMapperExample {

  public static void main(String[] args) {
    List<User> users = Arrays.asList(
        new User("Peter", 20, Arrays.asList("1", "2")),
        new User("Sam", 40, Arrays.asList("3", "4", "5")),
        new User("Ryan", 60, Collections.singletonList("6")),
        new User("Adam", 70, Arrays.asList("7", "8"))
    );

    users.stream().map(user -> user.getPhoneNumbers().stream())
        .flatMap(stringStream -> stringStream.filter(phoneNo -> phoneNo.compareTo("2") > 0))
        .forEach(System.out::println);

    Optional<String> stringOptional = users.stream().map(user -> user.getPhoneNumbers().stream())
        .flatMap(stringStream -> stringStream.filter(phoneNo -> phoneNo.compareTo("2") > 0))
        .findAny();
    stringOptional.ifPresent(System.out::println);
  }

  static class User {

    private String name;
    private Integer age = 30;
    private List<String> phoneNumbers;

    User(String name, Integer age, List<String> phoneNumbers) {
      this.name = name;
      this.age = age;
      this.phoneNumbers = phoneNumbers;
    }

    List<String> getPhoneNumbers() {
      return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
      this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getAge() {
      return age;
    }

    public void setAge(Integer age) {
      this.age = age;
    }

    @Override
    public String toString() {
      return "User{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }

}
