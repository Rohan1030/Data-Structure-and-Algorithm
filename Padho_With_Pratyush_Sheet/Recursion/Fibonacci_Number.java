package Padho_With_Pratyush_Sheet.Recursion;

   // Leetcode :- 509. Fibonacci Number

class Solution {

    public int fib(int n) {

        // Base case: Fibonacci(0) = 0
        if (n == 0) {
            return 0;
        }

        // Base case: Fibonacci(1) = 1
        if (n == 1) {
            return 1;
        }

        // Recursively calculate the previous two Fibonacci numbers
        int ans1 = fib(n - 1);
        int ans2 = fib(n - 2);

        // Return their sum
        return ans1 + ans2;
    }
}
