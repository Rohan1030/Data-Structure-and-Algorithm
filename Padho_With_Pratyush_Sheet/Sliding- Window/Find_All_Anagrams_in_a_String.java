// 438. Find All Anagrams in a String

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        int n = s.length();
        int m = p.length();

        ArrayList<Integer> list = new ArrayList<>();

        // If s is smaller than p, no anagrams are possible
        if (n < m) {
            return list;
        }

        int[] freq = new int[26];
        int[] window = new int[26];

        // Store frequency of p
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < n; right++) {

            // Add current character to window
            window[s.charAt(right) - 'a']++;

            // Shrink window if size exceeds m
            if (right - left + 1 > m) {
                window[s.charAt(left) - 'a']--;
                left++;
            }

            // Compare frequencies when window size is m
            if (right - left + 1 == m) {
                if (matches(freq, window)) {
                    list.add(left);
                }
            }
        }

        return list;
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