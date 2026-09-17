// Identical Arrays
// Module 1 Programming Assignment (3)
// Author: Carson Hebner

import java.util.Scanner;

public class programmingAssignment3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // creating the two 2-d arrays (m1 and m2)
        int[][] m1;
        int[][] m2;

        m1 = new int[3][3];
        m2 = new int[3][3];

        // filling m1
        System.out.print("Enter m1 (a 3 by 3 matrix) row by row: ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m1[i][j] = scanner.nextInt();
            }
        }

        // filling m2
        System.out.print("Enter m2 (a 3 by 3 matrix) row by row: ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m2[i][j] = scanner.nextInt();
            }
        }

        // final output (identical or different)
        boolean identical = equals(m1, m2);

        if (identical == true) {
            System.out.println("The two arrays are identical ");
        } else {
            System.out.println("The two arrays are different ");
        }

    }

    // method that determines if the two arrays are identical
    public static boolean equals(int[][] m1, int[][] m2) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;

    }

}
