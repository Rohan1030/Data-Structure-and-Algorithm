

    // GFG :- Sum of Digit

class Solution {

    static int sumOfDigits(int n) {

        // Start the recursive process
        return Sum(n);
    }

    // Recursive function to calculate the sum of digits
    static int Sum(int n) {

        // Base case: no digits left
        if (n == 0) {
            return 0;
        }

        // Extract the last digit
        int digit = n % 10;

        // Remove the last digit
        n = n / 10;

        // Recursively find the sum of remaining digits
        int remainingSum = Sum(n);

        // Add the current digit to the remaining sum
        return remainingSum + digit;
    }
}