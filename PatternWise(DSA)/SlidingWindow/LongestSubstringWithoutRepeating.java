package SlidingWindow;

import java.util.HashMap;


  class  LongestSubstringWithoutRepeating  {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        int n = s.length();
        int left=0;
        int maxLen = 0;

        for(int right=0;right<n;right++)
        {
            char c = s.charAt(right);
            if(map.containsKey(c))
            {
                left = Math.max(left,map.get(c)+1);

            }
             
        
                map.put(c,right);
                maxLen = Math.max(maxLen , right-left+1);
            
            

        }
        return maxLen;



        
    }
}
  

