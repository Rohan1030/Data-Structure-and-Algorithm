package SlidingWindow;
public class LongestRepeatingCharacterReplacement {

  // leetcode Qno:- 424. Longest Repeating Character Replacement
  class Solution {
    public int characterReplacement(String s, int k) {

        int[] count = new int[26]; // use to count alphabate in string s
        int left=0;
        int maxfreq =0; 
        int maxLen =0;


        for(int right=0;right<s.length();right++)
        {
            char c = s.charAt(right);

            count[c-'A']++;

            maxfreq = Math.max(maxfreq , count[c-'A']);

            int windowLength = right-left+1;
            
            if(windowLength-maxfreq>k)
            {
                count[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen , right-left+1);


        }
        


    return maxLen;
        
    }
}
  
}
