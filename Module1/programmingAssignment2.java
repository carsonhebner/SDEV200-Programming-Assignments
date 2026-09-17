
// Credit Card Validity Checker
// Module 1 Programming Assignment (2)
// Author: Carson Hebner
import java.util.Scanner;

public class programmingAssignment2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long number;

        System.out.print("Enter a credit card number as a long integer: ");
        number = scanner.nextLong();

        // creating an array to hold each digit of the card number
        int numberSize = getSize(number);
        int[] numbersArray = new int[numberSize];
        String numberString = String.valueOf(number);

        for (int i = 0; i < numberSize; i++) {
            numbersArray[i] = numberString.charAt(i) - '0';
        }

        //making new arrays to hold the odd numbers and the even numbers
        int[] updatedOddArray = new int[numberSize];
        int[] updatedEvenArray = new int[numberSize];

        //calling different methods
        updatedOddArray = sumOfDoubleOddPlace(number, updatedOddArray, numbersArray);
        int oddSum = getDigit(numberSize, updatedOddArray);
        int evenSum = sumOfEvenPlace(number, updatedEvenArray, numbersArray);
        int totalSum = evenSum + oddSum;
        boolean valid = isValid(number, totalSum);

        //final output (valid or invalid)
        if (valid == true) {
            System.out.println(number + " is valid.");
        } else {
            System.out.println(number + " is invalid.");
        }

    }

    // doubles very second digit from right to left and holds those in an array
    public static int[] sumOfDoubleOddPlace(long number, int[] updatedOddArray, int[] numbersArray) {

        int numberSize = getSize(number);

        for (int i = 0; i < numberSize; i++) {
            int distanceFromRight = numberSize - 1 - i;
            if (distanceFromRight % 2 == 1) {
                updatedOddArray[i] = numbersArray[i] * 2;
            }
        }
        return updatedOddArray;
    }

    // determines if i need to add digits together, then gets sum of odd digits
    public static int getDigit(int numberSize, int[] updatedOddArray) {

        for (int i = 0; i < numberSize; i++) {
            if (updatedOddArray[i] <= 9) {
                updatedOddArray[i] = updatedOddArray[i];
            } else {
                updatedOddArray[i] = (updatedOddArray[i] / 10) + (updatedOddArray[i] % 10);
            }
        }

        int oddSum = 0;

        for (int i = 0; i < numberSize; i++) {
            oddSum = updatedOddArray[i] + oddSum;
        }

        return oddSum;
    }

    // sums up all the even digits 
    public static int sumOfEvenPlace(long number, int[] updatedEvenArray, int[] numbersArray) {
        int numberSize = getSize(number);

        for (int i = 0; i < numberSize; i++) {
            int distanceFromRight = numberSize - 1 - i;
            if (distanceFromRight % 2 == 0) {
                updatedEvenArray[i] = numbersArray[i];
            }
        }
        int evenSum = 0;

        for (int i = 0; i < numberSize; i++) {
            evenSum = updatedEvenArray[i] + evenSum;
        }
        return evenSum;

    }

    // yes or no if prefix matched with visa, mastercard, discover, or amex
    public static boolean prefixmatched(long number) {
        String numberString = String.valueOf(number);
        if (numberString.charAt(0) == '4' || numberString.charAt(0) == '5' || numberString.charAt(0) == '6') {
            return true;
        }
        if (numberString.charAt(0) == '3' && numberString.charAt(1) == '7') {
            return true;
        }
        return false;
    }

    // returns how many digits in card number
    public static int getSize(long number) {
        int numberSize = String.valueOf(number).length();
        return numberSize;

    }

    // determines the final yes or no (valid or invalid)
    public static boolean isValid(long number, int totalSum) {
        boolean validPrefix = prefixmatched(number);

        if (totalSum % 10 == 0 && validPrefix == true) {
            return true;
        }
        return false;
    }

}
