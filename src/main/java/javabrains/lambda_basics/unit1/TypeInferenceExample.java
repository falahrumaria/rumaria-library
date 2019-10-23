package javabrains.lambda_basics.unit1;

public class TypeInferenceExample {

    public static void main(String[] args) {
        printLambda(str -> str.length());
    }

    public static void printLambda(StringLengthLambda myLambda) {
        System.out.println(myLambda.getLength("aku orang baik"));
    }
    interface StringLengthLambda {
        int getLength(String string);
    }
}
