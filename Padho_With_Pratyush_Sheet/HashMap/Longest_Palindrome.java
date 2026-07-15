    //  409. Longest Palindrome


class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        // Calculate maximum palindrome length
        for (int count : map.values()) {

            // Use all even occurrences
            if (count % 2 == 0) {
                length += count;
            } 
            // Use count - 1 for odd occurrences
            else {
                length += count - 1;
                hasOdd = true;
            }
        }

        // Add one odd character to the center
        if (hasOdd) {
            length++;
        }

        return length;
    }
}