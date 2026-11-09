// Plane Tracker 
// SDEV-200 Final Project (11/8/26)
// Author: Carson Hebner

import java.util.Scanner;

// test class for testing my program
public class test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FlightLog log = new FlightLog();

        boolean isExit = false;
        while (isExit == false) {

            // printing out the menu
            System.out.println("________________________");
            System.out.println("| 1. Add Plane         |");
            System.out.println("| 2. View Planes       |");
            System.out.println("| 3. View Last Five    |");
            System.out.println("| 4. Quit              |");
            System.out.println("------------------------");

            int choice = scanner.nextInt();

            // asking for plane info and adding plane to the log
            if (choice == 1) {
                System.out.println();
                System.out.println("Enter Aircraft Type Ex. B737");
                String aircraftType = scanner.next();
                System.out.println("Enter Aircrafts To and From Location Ex. CHI-IND");
                String toFrom = scanner.next();
                scanner.nextLine();
                System.out.println("Enter Aircraft Altitude Ex. 32000");
                boolean valid = false;
                int altitude = 0;
                while (!valid) {
                    try {
                        String altitudeText = scanner.nextLine();
                        altitude = Integer.parseInt(altitudeText);
                        valid = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid: Please Enter a Number for Altitude. ");
                    }
                }
                System.out.println("Enter Aircrafts Callsign Ex. SWA3440");
                String callsign = scanner.next();
                scanner.nextLine();
                System.out.println("Enter The Time of Recording Ex. Nov. 5 at 7:15pm");
                String timeOfRecording = scanner.nextLine();
                System.out.println("Is The Aircraft Commercial or Private Ex. commercial");
                String commercialOrPrivate = scanner.next();
                LoggedPlane plane = new LoggedPlane(aircraftType, toFrom, altitude, callsign, timeOfRecording,
                        commercialOrPrivate);

                log.addPlane(plane);
            }

            // outputting each plane in the log
            if (choice == 2) {
                for (LoggedPlane plane : log.getPlanes()) {
                    System.out.println(plane.getAircraftType() + " | " + plane.getToFrom() + " | " + plane.getAltitude()
                            + " | " + plane.getCallsign() + " | " + plane.getTimeOfRecording() + " | "
                            + plane.getCommercialOrPrivate());
                }
                System.out.println();
                System.out.println("Total Planes Counted: " + Plane.getPlaneCount());

            }

            // outputting the last five planes in the log
            if (choice == 3) {
                for (LoggedPlane plane : log.getLastFive()) {
                    System.out.println(plane);
                }
            }

            // to quit
            if (choice == 4) {
                isExit = true;
            }

        }
    }

}
