package javabrains.lambda_basics.unit3;

public class MethodReferenceExample {

    public static void main(String[] args) {
        Thread myThread = new Thread(() -> printMessage());
        myThread.start();
        myThread = new Thread(MethodReferenceExample::printMessage);
        myThread.start();
    }

    private static void printMessage() {
        System.out.println("hello world");
    }
}
