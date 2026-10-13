// Match grouping symbols
// Module 4 Programming Assignment (1)
// Author: Carson Hebner

// This program requires you to manualy compile and run the file.
// It utalizes a COMMAND-LINE ARGUMENT
// You must compile the file, then paste the file you want to test behind this file
// EXAMPLE: javac module4programmingAssignment1.java 
//          java module4programmingAssignment1 test.txt 
//
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class module4programmingAssignment1 {

    public static void main(String[] args) {

        // creating the stack
        Stack<Character> groupingSymbols = new Stack<>();

        // creating file 
        File myFile = new File(args[0]);
        boolean invalid = false;

        // scanner to read the file and the logic for checking correct pairs
        try (Scanner reading = new Scanner(myFile)) {
            while (reading.hasNextLine()) {
                String data = reading.nextLine();
                System.out.println(data);
                for (int i = 0; i < data.length(); i++) {
                    if (data.charAt(i) == '(' || data.charAt(i) == '[' || data.charAt(i) == '{') {
                        groupingSymbols.push(data.charAt(i));
                    } else if (data.charAt(i) == ')' || data.charAt(i) == ']' || data.charAt(i) == '}') {
                        if (!groupingSymbols.isEmpty()) {
                            if (groupingSymbols.peek() == '(' && data.charAt(i) == ')' || groupingSymbols.peek() == '{' && data.charAt(i) == '}' || groupingSymbols.peek() == '[' && data.charAt(i) == ']') {
                                groupingSymbols.pop();
                            } else {
                                invalid = true;
                            }
                        } else {
                            invalid = true;
                        }

                    }
                }
            }
            // outputting wether its valid or invalid
            if (invalid == true || !groupingSymbols.isEmpty()) {
                System.out.println("Invalid grouping pairs ");
            } else {
                System.out.println("Valid grouping pairs ");
            }

            // exceptions 
        } catch (FileNotFoundException e) {
            System.out.println(e);

        }

    }
}
