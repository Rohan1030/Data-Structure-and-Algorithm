package SlidingWindow;

public class MaxSubarray {

  // Leetcode
  class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left=0;
        int window =0;
        int n = nums.length;

        for(int right=0;right<n;right++)
        {
            window += nums[right];
            while(window>=target)
            {
                ans = Math.min(ans,right-left+1);
                window -= nums[left];
                left++;
            }


        }
        if(ans == Integer.MAX_VALUE )
        return 0;
        else 
        return ans;

        
    }
}
   
  
}
