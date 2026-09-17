// Geometry: n-sided Regular Polygon
// Module 1 Programming Assignment (4)
// Author: Carson Hebner

public class programmingAssignment4 {

    public static void main(String[] args) {

        // Outputting the three polygons from the created objects
        RegularPolygon polygon1 = new RegularPolygon();
        System.out.println("The perimeter of a polygon with " + polygon1.getN() + " sides, and a side length of " + polygon1.getSide() + " is " + polygon1.getPerimeter());
        System.out.println("The area of a polygon with " + polygon1.getN() + " sides, and a side length of " + polygon1.getSide() + " is " + polygon1.getArea());
        System.out.println();

        RegularPolygon polygon2 = new RegularPolygon(6, 4);
        System.out.println("The perimeter of a polygon with " + polygon2.getN() + " sides, and a side length of " + polygon2.getSide() + " is " + polygon2.getPerimeter());
        System.out.println("The area of a polygon with " + polygon2.getN() + " sides, and a side length of " + polygon2.getSide() + " is " + polygon2.getArea());
        System.out.println();

        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.println("The perimeter of a polygon with " + polygon3.getN() + " sides, and a side length of " + polygon3.getSide() + " is " + polygon3.getPerimeter());
        System.out.println("The area of a polygon with " + polygon3.getN() + " sides, and a side length of " + polygon3.getSide() + " is " + polygon3.getArea());
        System.out.println();
    }
}

// class that holds polygons and logic
class RegularPolygon {

    private int n;
    private double side;
    private double x;
    private double y;

    // accessors/ mutators
    public int getN() {
        return n;
    }

    public double getSide() {
        return side;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setN(int numsides) {
        n = numsides;
    }

    public void setSide(double sidelength) {
        side = sidelength;
    }

    public void setX(double xcoord) {
        x = xcoord;
    }

    public void setY(double ycoord) {
        y = ycoord;
    }

    // the three constructors (no-arg, 2-arg, 4-arg)
    public RegularPolygon() {
        n = 3;
        side = 1;
        x = 0;
        y = 0;
    }

    public RegularPolygon(int numsides, double sidelength) {

        n = numsides;
        side = sidelength;
        x = 0;
        y = 0;

    }

    public RegularPolygon(int numsides, double sidelength, double xcoord, double ycoord) {

        n = numsides;
        side = sidelength;
        x = xcoord;
        y = ycoord;

    }

    // two methods for calculating perimeter and area
    public double getPerimeter() {
        return n * side;
    }

    public double getArea() {
        return (n * (side * side)) / (4 * Math.tan(Math.PI / n));
    }

}
