package javabrains.lambda_basics.unit1;

public class Greeter {

  public static void main(String[] args) {
    Greeter greeter = new Greeter();
    HelloWorldGreeting hwg = new HelloWorldGreeting();

    Greeting greeting = new Greeting() {
      @Override
      public void perform() {
        System.out.println("Hello world!");
      }
    };

    Greeting doGreet = () -> System.out.println("Hello world!");

    greeter.greet(hwg);
    greeter.greet(greeting);
    greeter.greet(doGreet);
  }

  public void greet(Greeting greeting) {
    greeting.perform();
  }
}
