package rumaria.test.xtremax;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LiveCoding1 {
    /**
     * Special Number
     * Special Number is list of non-negative integer that is constructed from non-negative integer
     * Special Number has two operations, Special Summation and Special Multiplication
     * <p>
     * You must implement specialSummation and Special Multiplication Method
     * See explanation for each method below
     * <p>
     * DO NOT CHANGE THE CODE IN MAIN
     *
     * @param args
     */
    public static void main(String[] args) {
        testResult(6, specialSummation(100000005));
        testResult(4, specialSummation(900000607));

        testResult(6, specialMultiplication(123));
        testResult(0, specialMultiplication(587));
    }

    private static void testResult(int expected, int actual) {
        if (expected == actual) {
            System.out.println("Answer is correct");
        } else {
            System.out.println(
                    String.format("Answer is wrong. Expected level is %d but your result is %d", expected, actual)
            );
        }
    }

    /**
     * specialSummation is sums of all digit in Special Number
     * Example:
     * >>> specialSummation(123)
     * >>> 6   (from 1+2+3)
     * <p>
     * >>> specialSummation(567)
     * >>> 9   (from 5+6+7 = 18 then 1+8 = 9)
     *
     * @param number Non negative integer to sum
     * @return Summation of Special Number
     */
    private static int specialSummation(int number) {
        // AMEND YOUR CODE BELOW THIS LINE
        if (number < 0) {
            throw new NotImplementedException();
        }
        if (number < 10) {
            return number;
        }
        int currentSum = 0;
        int sisa = number % 10;
        number /= 10;
        currentSum += sisa;
        while (number > 0) {
            sisa = number % 10;
            number /= 10;
            currentSum += sisa;
        }
        return specialSummation(currentSum);
        // AMEND YOUR CODE ABOVE THIS LINE
    }

    /**
     * specialMultiplication is multiplication of all digit in Special Number
     * Example:
     * >>> specialMultiplication(123)
     * >>> 6   (from 1*2*3)
     * <p>
     * >>> specialSummation(567)
     * >>> 0   (from 5*6*7 = 210 then 2*1*0 = 0)
     *
     * @param number Non negative integer to multiply
     * @return Multiplication of Special Numbber
     */
    private static int specialMultiplication(int number) {
        // AMEND YOUR CODE BELOW THIS LINE
        if (number < 0) {
            throw new NotImplementedException();
        }
        if (number < 10) {
            return number;
        }
        int currentMultiplication = 1;
        int sisa = number % 10;
        number /= 10;
        currentMultiplication *= sisa;
        while (number > 0) {
            sisa = number % 10;
            number /= 10;
            currentMultiplication *= sisa;
        }
        return specialMultiplication(currentMultiplication);
        // AMEND YOUR CODE ABOVE THIS LINE
    }
}
