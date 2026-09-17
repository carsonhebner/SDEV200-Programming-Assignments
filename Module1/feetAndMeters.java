
// Conversion Calculator
// Module 1 Programming Assignment
// Author: Carson Hebner
import java.util.Scanner;

public class feetAndMeters {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Welcome menu 
        System.out.println("Welcome to the Conversion Calculator!");
        System.out.println();
        System.out.println("This program will convert feet to meters & vice-versa. ");
        System.out.println();
        System.out.println("Instructions: ");
        System.out.println("You will first convert feet to meters. ");
        System.out.println("Then, if you would like, you can convert meters to feet.");
        System.out.println();
        System.out.println("IMPORTANT: When prompted, please enter measurements ONE AT A TIME, and press ENTER.");
        System.out.println();
        System.out.println("To continue, type 1, and press ENTER");

        int choice = scanner.nextInt();

        double[] feetList = new double[0];
        double[] meterList = new double[0];

        int feetMesurementNum = 0;
        int meterMesurementNum = 0;
        int yesToOpposing = 0;

        if (choice == 1) {
            System.out.println("How many measurements would you like to convert to meters? ");
            feetMesurementNum = scanner.nextInt();

            feetList = new double[feetMesurementNum];

            for (int i = 0; i < feetMesurementNum; i++) {
                System.out.println("Enter each measurement SEPARTLY, and press ENTER. (Ex. 1, 2, 3, ...)");
                double foot = scanner.nextDouble();
                feetList[i] = foot;
            }

            System.out.println("Thank you, would you also like to convert meters to feet? ");
            System.out.println();
            System.out.println("If YES, type 2, and press ENTER. ");
            System.out.println("If NO, type 3, and press ENTER. ");
            yesToOpposing = scanner.nextInt();

        }

        if (choice == 2 || yesToOpposing == 2) {
            System.out.println("How many measurements would you like to convert to feet? ");
            meterMesurementNum = scanner.nextInt();

            meterList = new double[meterMesurementNum];

            for (int i = 0; i < meterMesurementNum; i++) {
                System.out.println("Enter each measurement SEPARTLY, and press ENTER. (Ex. 20, 45, 60, ...)");
                double meter = scanner.nextDouble();
                meterList[i] = meter;
            }

        } else if (yesToOpposing == 3) {
            System.out.println("No meter measurements added. ");
            System.out.println("Displaying results...");
            System.out.println();

        } else {
            System.out.println("Invalid choice. ");
            System.out.println();
            System.out.println("Continuing...");
            System.out.println("Printing data... ");

        }

        int maxMesurement = Math.max(feetMesurementNum, meterMesurementNum);

        // Final results outputted
        System.out.println("Feet    Meters          Meters      Feet");
        System.out.println("----------------------------------------");

        for (int i = 0; i < (maxMesurement); i++) {

            String feetCol;
            if (i < feetMesurementNum) {
                feetCol = feetList[i] + "\t" + footToMeter(feetList[i]);
            } else {
                feetCol = "\t";
            }

            String metCol;
            if (i < meterMesurementNum) {
                metCol = meterList[i] + "\t" + meterToFoot(meterList[i]);
            } else {
                metCol = "\t";
            }

            System.out.println(feetCol + "\t\t" + metCol);

        }

    }

    // Two methods that calculate the conversions
    public static double footToMeter(double foot) {
        double meter = .305 * foot;

        return meter;
    }

    public static double meterToFoot(double meter) {
        double foot = 3.279 * meter;

        return foot;
    }
}
