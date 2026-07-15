//1189. Maximum Number of Balloons

class Solution {
    public int maxNumberOfBalloons(String text) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();

        // Count characters needed for "balloon"
        for (char c : "balloon".toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // Count characters available in the input
        for (char c : text.toCharArray()) {
            have.put(c, have.getOrDefault(c, 0) + 1);
        }

        int ans = Integer.MAX_VALUE;

        // Find how many times each required character can be used
        for (char c : need.keySet()) {
            int required = need.get(c);
            int available = have.getOrDefault(c, 0);

            ans = Math.min(ans, available / required);
        }

        return ans;
    }
}


// other easy way 

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        
        for (char c : text.toCharArray()) {
            counts[c - 'a']++;
        }
        
        int b = counts['b' - 'a'];
        int a = counts['a' - 'a'];
        int l = counts['l' - 'a'] / 2; 
        int o = counts['o' - 'a'] / 2; 
        int n = counts['n' - 'a'];
        
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}