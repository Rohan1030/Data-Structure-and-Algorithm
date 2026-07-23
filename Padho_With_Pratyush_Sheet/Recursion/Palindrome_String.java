//  GFG :-  Palindrome String

// Using recursion 
class Solution {

    boolean isPalindrome(String s) {
        return check(s, 0, s.length() - 1);
    }

    // Recursive function
    boolean check(String s, int left, int right) {

        // Base case: pointers crossed or met
        if (left >= right) {
            return true;
        }

        // Characters don't match
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        // Check the remaining string
        return check(s, left + 1, right - 1);
    }
}










      // Normal Approach


class Solution {

    boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        // Compare characters from both ends
        while (left < right) {

            // If characters don't match, not a palindrome
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            // Move towards the center
            left++;
            right--;
        }

        // All characters matched
        return true;
    }
}