package TwoPointer;
import java.util.*;

public class BackspaceStringCompare {

    public static void main(String[] args) {

        // Input strings
        String s = "ab#c";
        String t = "ad#c";

        // Call static method directly (no object needed)
        boolean result = backspaceCompare(s, t);

        // Print output
        System.out.println("String s: " + s);
        System.out.println("String t: " + t);
        System.out.println("Are both strings equal after backspace? " + result);
    }

    /*
     * This method compares two strings after applying
     * backspace operations ('#').
     */
    public static boolean backspaceCompare(String s, String t) {

        // Build final strings and compare them
        return build(s).equals(build(t));
    }

    /*
     * This helper method processes the string using a stack:
     * - Normal characters are pushed into the stack
     * - '#' removes the last character (if exists)
     */
    private static String build(String str) {

        // Stack to simulate typing with backspace
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the string
        for (char ch : str.toCharArray()) {

            if (ch == '#') {
                // Backspace: remove last character if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                // If stack is empty, do nothing
            } 
            else {
                // Normal character: add to stack
                stack.push(ch);
            }
        }

        // Convert stack into final string
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
