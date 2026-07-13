//3. Longest Substring Without Repeating Characters


class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int result = 0;

        // Stores frequency of characters in the current window
        HashMap<Character, Integer> freq = new HashMap<>();

        // Expand the window
        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // Include current character in the window
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Window becomes invalid if current character repeats
            while (freq.get(c) > 1) {

                char leftChar = s.charAt(left);

                // Remove leftmost character from the window
                freq.put(leftChar, freq.get(leftChar) - 1);

                // Clean up map if frequency becomes 0
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }

                // Shrink the window
                left++;
            }

            // Window is valid → update maximum length
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}