// BinaryFormatException
// Module 2 Programming Assignment (3)
// Author: Carson Hebner

import java.util.Scanner;

public class module2programmingAssigment3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String binaryString;

        // prompting user for binary number
        System.out.println("Enter a binary number as a string. ");
        binaryString = scanner.nextLine();

        // creating an object for the number
        module2programmingAssigment3 mynumber = new module2programmingAssigment3();

        // testing the number and catching if its invalid
        try {
            mynumber.bin2Dec(binaryString);
            System.out.println(mynumber.bin2Dec(binaryString));
        } catch (BinaryFormatException e) {
            System.out.println(e);
        }

    }

    // method for converting binary to decimal and holds logic for validity
    public double bin2Dec(String binaryString) throws BinaryFormatException {

        double sum = 0;
        int pow = 0;

        for (int i = binaryString.length() - 1; i >= 0; i--) {
            if (binaryString.charAt(i) < '0' || binaryString.charAt(i) > '1') {
                throw new BinaryFormatException("String is not a binary number. ");
            }
            sum = (binaryString.charAt(i) - '0') * Math.pow(2, pow) + sum;
            pow++;
        }
        return sum;
    }
}

// class that holds the exception message
class BinaryFormatException extends Exception {

    public BinaryFormatException(String message) {
        super(message);
    }

}
