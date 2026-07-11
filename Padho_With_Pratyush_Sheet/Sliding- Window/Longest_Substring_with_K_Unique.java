import java.util.*;

class Solution {
    public int longestKSubstr(String s, int k) {
        
        int left = 0;
        int n = s.length();
        int maxLen = -1; // -1 = no valid window found yet
        
        HashMap<Character, Integer> freq = new HashMap<>(); // char -> count in current window
        
        for (int right = 0; right < n; right++) // expand window one char at a time
        {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1); // add current char to window
            
            // too many distinct chars -> shrink from left until valid
            while (freq.size() > k)
            {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1); // remove one occurrence
                
                if (freq.get(leftChar) == 0)
                {
                    freq.remove(leftChar); // char fully gone from window, drop the key
                }
                left++; // shrink window
            }
            
            // check AFTER shrinking, on every iteration (not just when shrinking happens)
            if (freq.size() == k)
            {
                int currWindowLen = right - left + 1;
                maxLen = Math.max(maxLen, currWindowLen); // update best answer
            }
        }
        return maxLen;
    }
}