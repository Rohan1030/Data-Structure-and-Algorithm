package FastAndSlowPointers;
import java.util.*;
public class HappyNumber {

    // Helper method: returns sum of squares of digits
    public static int square(int num) {
        int ans = 0;

        while (num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num = num / 10;
        }

        return ans;
    }

    // Method to check if number is happy
    public static boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = square(slow);            // move 1 step
            fast = square(square(fast));    // move 2 steps
        } while (slow != fast);

        // if both meet at 1 → happy number
        return slow == 1;
    }

    // MAIN method for VS Code
    public static void main(String[] args) {

        int n1 = 19;
        int n2 = 2;

        System.out.println(n1 + " is happy? " + isHappy(n1));
        System.out.println(n2 + " is happy? " + isHappy(n2));
    }
}
