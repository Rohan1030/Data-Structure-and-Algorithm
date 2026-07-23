//  GFG :-  Palindrome String

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