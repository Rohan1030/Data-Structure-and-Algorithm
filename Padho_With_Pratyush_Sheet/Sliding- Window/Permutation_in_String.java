
      //567. Permutation in String

class Solution {

    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        // If s2 is smaller, permutation is impossible
        if (m < n) {
            return false;
        }

        int[] freq = new int[26];
        int[] window = new int[26];

        // Store frequency of s1
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < m; right++) {

            // Add current character to window
            window[s2.charAt(right) - 'a']++;

            // Shrink window if size exceeds n
            if (right - left + 1 > n) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            // Compare frequencies when window size is n
            if (right - left + 1 == n) {
                if (matches(freq, window)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Compare both frequency arrays
    private boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}