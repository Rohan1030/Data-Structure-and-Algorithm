package SlidingWindow;
import java.util.*;
import java.util.HashMap;

public class MinimumWindowSubstring {
  
  class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";

        // Storing t into hashmap tmap

        HashMap<Character,Integer> tmap = new HashMap<>();
        for(char c : t.toCharArray())
        {
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }




        HashMap<Character , Integer> window = new HashMap<>();
        
        int count =0;
        int need = tmap.size();
        int left=0;
        int minLen = Integer.MAX_VALUE;
        int start =0;

        for(int right=0;right<s.length();right++)
        {
            char c = s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            if(tmap.containsKey(c) && window.get(c).intValue() == tmap.get(c).intValue())
            {
                count++;
            }

            while(count==need)
            {
                if(right-left+1 <minLen)
                {
                    minLen = right-left+1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar,window.get(leftChar)-1);



                if(tmap.containsKey(leftChar) && window.get(leftChar)<tmap.get(leftChar) )
                {
                    count--;
                }
                left++;

            }
           

        }



        return (minLen==Integer.MAX_VALUE) ? "" : s.substring(start,start+minLen);

        
    }
}
}
