package SlidingWindow;
import java.util.*;
import java.util.HashMap;

public class SubarrayswithKDifferentIntegers {

          // Brute force Approach [Leetcode :- 992]

  class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            map.clear(); // Reset map for each new starting index
            for (int j = i; j < n; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                
                if (map.size() == k) {
                    count++;
                } else if (map.size() > k) {
                    break;
                }
            }
        }
        return count;
    }
}

  
}









                          // optimal approach 

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

            return atMost(nums,k) - atMost(nums,k-1); 
    }

        private int atMost(int[] nums , int k)
        {
        int left =0;
        int n = nums.length;
        int count =0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int right=0;right<n;right++)
        {
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            while(map.size()>k)
            {
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0)
                    map.remove(nums[left]);
                    left++;
                }
                 count += right-left+1;
            }


            return count;
          


        }
     
 
    
}

