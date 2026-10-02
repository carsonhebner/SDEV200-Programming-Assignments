// Use BigInteger for the Rational class
// Module 3 Programming Assignment (2)
// Author: Carson Hebner

//this file was taken from a template
// Look for WRITE YOUR CODE to write your code (my code is below the WRITE YOUR CODE comment)
import java.math.*;
import java.util.Scanner;

public class module3programmingAssignment2 {

    public static void main(String[] args) {
        // Prompt the user to enter two Rational numbers
        Scanner input = new Scanner(System.in);
        System.out.print("Enter rational r1 with numerator and denominator seperated by a space: ");
        String n1 = input.next();
        String d1 = input.next();

        System.out.print("Enter rational r2 with numerator and denominator seperated by a space: ");
        String n2 = input.next();
        String d2 = input.next();

        RationalUsingBigInteger r1 = new RationalUsingBigInteger(
                new BigInteger(n1), new BigInteger(d1));
        RationalUsingBigInteger r2 = new RationalUsingBigInteger(
                new BigInteger(n2), new BigInteger(d2));

        // Display results
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());
    }
}

// Name the revised Rational class RationalUsingBigInteger 
class RationalUsingBigInteger extends Number
        implements Comparable<RationalUsingBigInteger> {
    // Data fields for numerator and denominator

    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    // WRITE YOUR CODE
    public RationalUsingBigInteger() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    // simplifiying fraction
    public RationalUsingBigInteger(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    // two getter methods
    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    //adding
    public RationalUsingBigInteger add(RationalUsingBigInteger secondNumber) {
        BigInteger n = numerator.multiply(secondNumber.getDenominator()).add(denominator.multiply(secondNumber.getNumerator()));
        BigInteger d = denominator.multiply(secondNumber.getDenominator());
        return new RationalUsingBigInteger(n, d);
    }

    //subtracting
    public RationalUsingBigInteger subtract(RationalUsingBigInteger secondNumber) {
        BigInteger n = numerator.multiply(secondNumber.getDenominator()).subtract(denominator.multiply(secondNumber.getNumerator()));
        BigInteger d = denominator.multiply(secondNumber.getDenominator());
        return new RationalUsingBigInteger(n, d);
    }

    //multiplying
    public RationalUsingBigInteger multiply(RationalUsingBigInteger secondNumber) {
        BigInteger n = numerator.multiply(secondNumber.getNumerator());
        BigInteger d = denominator.multiply(secondNumber.getDenominator());
        return new RationalUsingBigInteger(n, d);
    }

    //dividing
    public RationalUsingBigInteger divide(RationalUsingBigInteger secondNumber) {
        BigInteger n = numerator.multiply(secondNumber.getDenominator());
        BigInteger d = denominator.multiply(secondNumber.getNumerator());
        return new RationalUsingBigInteger(n, d);
    }

    // turing fraction into whole number and/or displaying the fraction as a string
    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator + "";
        } else {
            return numerator + "/" + denominator;
        }
    }

    //checks to see if they are equal 
    @Override
    public boolean equals(Object other) {
        if ((this.subtract((RationalUsingBigInteger) (other))).getNumerator().equals(BigInteger.ZERO)) {
            return true;
        } else {
            return false;
        }
    }

    //checks to see what fraction is bigger
    @Override
    public int compareTo(RationalUsingBigInteger o) {
        if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0) {
            return 1;
        } else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    // methods to convert fractions into differnt data types
    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

}
