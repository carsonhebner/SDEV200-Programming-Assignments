// Count the keywords in Java source code
// Module 4 Programming Assignment (2)
// Author: Carson Hebner

// When entering the Java source file as input, do it as a path!
//
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class module4programmingAssignment2 {

    public static void main(String[] args) throws Exception {

        // outputting data
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Java source file (as a path): ");
        String filename = input.nextLine();

        File file = new File(filename);
        if (file.exists()) {
            System.out.println("The number of keywords in " + filename + " is " + countKeywords(file));
        } else {
            System.out.println("File: " + filename + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception {

        // array of keywords
        String[] keywords = {"abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const", "continue", "default", "do",
            "double", "else", "enum", "extends", "for", "final", "finally", "float",
            "goto", "if", "implements", "import", "instanceof", "int", "interface", "long",
            "native", "new", "package", "private", "protected", "public", "return", "short",
            "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while", "true", "false", "null"};

        // creating a hashset for the keywords
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));

        // creating a stack for the quotes to ignore strings
        Stack<Character> quotes = new Stack<>();

        int count = 0;

        Scanner input = new Scanner(file);

        // logic for ignoring strings
        while (input.hasNext()) {
            String word = input.next();
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '"') {
                    if (quotes.isEmpty()) {
                        quotes.push(word.charAt(i));
                    } else {
                        quotes.pop();
                    }
                }
            }

            // incrementing by one
            if (keywordSet.contains(word) && quotes.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
