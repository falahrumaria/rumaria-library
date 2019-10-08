package rumaria.library.lambda_basics.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Unit1ExerciseSolutionJava8 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39));

//        Step 1: Sort list by last name
        Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

//        Step 2: Create a method that prints elements in the list
        System.out.println("print all");
        printConditionally(people, p -> true);

//        Step 3: Create a method that prints all people with a condition as an argument
        System.out.println("print all people whose last name starts with C");
        printConditionally(people, p -> p.getLastName().startsWith("C"));

        System.out.println("print all people whose first name starts with C");
        printConditionally(people, p -> p.getFirstName().startsWith("C"));
    }

    private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
        for (Person p : people) {
            if (predicate.test(p)) {
                System.out.println(p);
            }
        }
    }
}