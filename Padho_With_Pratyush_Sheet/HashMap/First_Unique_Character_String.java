// leetcode : - 387. First Unique Character in a String


class Solution {

    public int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Find the first character with frequency 1
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // No unique character found
        return -1;
    }
}