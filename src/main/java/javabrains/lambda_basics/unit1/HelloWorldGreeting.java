package javabrains.lambda_basics.unit1;

public class HelloWorldGreeting implements Greeting {

    @Override
    public void perform() {
        System.out.println("Hello world!");
    }
}
