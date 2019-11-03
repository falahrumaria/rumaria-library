package techprimers.java_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");

        // this code (imperative style)
        for (String name : names) {
            if (!name.equals("Sam")) {
                User user = new User(name);
                System.out.println(user);
            }
        }

        // is equivalent to (functional style)
        names.stream().filter(name -> !name.equals("Sam"))
                .map(User::new)
                .forEach(System.out::println);

        // collect example
        List<User> users = names.stream().filter(name -> !name.equals("Sam"))
                .map(User::new).collect(Collectors.toList());

        // mapToInt example
        int sum = users.stream().mapToInt(user -> user.getAge()).sum();
        System.out.println(sum);
    }

    static class User {
        private String name;
        private Integer age = 30;

        public User(String name) {
            this.name = name;
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
