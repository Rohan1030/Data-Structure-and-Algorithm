/*
 * LeetCode 424 - Longest Repeating Character Replacement
 *
 * Pattern: Sliding Window
 * Invalid Condition:
 * (Window Size - Max Frequency) > k
 *
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int maxFreq = 0;   // Highest frequency in current window
        int result = 0;

        // Frequency of A-Z
        int[] freq = new int[26];

        // Expand the window
        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // Include current character
            freq[c - 'A']++;

            // Update highest frequency
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            // Shrink while more than k replacements are needed
            while ((right - left + 1) - maxFreq > k) {

                char leftChar = s.charAt(left);

                // Remove left character
                freq[leftChar - 'A']--;

                left++;
            }

            // Update longest valid window
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}