// Geometry: The Triangle class
// Module 2 Programming Assignment (2)
// Author: Carson Hebner

/* IMPORTANT: make sure you have the GeometricObject.java file in the same folder 
OR compile them together before you run TestTriangle.java 

YOU NEED BOTH TO RUN THIS PROGRAM */
import java.util.Scanner;

public class TestTriangle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // prompting user for input
        System.out.println();
        System.out.println("IMPORTANT: When entering sides, make sure your sides make a REAL triangle (ex. 3, 4, 5)");
        System.out.println();
        System.out.println("Enter side 1 of your triangle: ");
        double side1 = scanner.nextDouble();

        System.out.println("Enter side 2 of your triangle: ");
        double side2 = scanner.nextDouble();

        System.out.println("Enter side 3 of your triangle: ");
        double side3 = scanner.nextDouble();

        System.out.println("Enter triangle color: ");
        String color = scanner.next();

        System.out.println("Enter if the triangle is filled (true for YES, false for NO): ");
        boolean filled = scanner.nextBoolean();

        // building myTriangle object
        Triangle myTriangle = new Triangle(side1, side2, side3);
        myTriangle.setColor(color);
        myTriangle.setFilled(filled);

        // outputting triangle data
        System.out.println();
        System.out.println("Triangle area: " + myTriangle.getArea());
        System.out.println("Triangle perimeter: " + myTriangle.getPerimeter());
        System.out.println("Triangle color: " + myTriangle.getColor());
        System.out.println("Triangle filled: " + myTriangle.isFilled());

    }
}

// class that holds triangle logic
class Triangle extends GeometricObject {

    private double side1;
    private double side2;
    private double side3;

    // two constructors (no-arg and 3-arg)
    public Triangle() {
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // the three accessor methods
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    // method for getting area
    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }

    // method for getting perimeter
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // method for printing triangle specs (not used in output)
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

}
