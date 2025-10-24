package BinarySearch;
import java.util.*;
public class SplitArrayLargestSum {


  // leetcode :- 410. Split Array Largest Sum

  class Solution {
    public int splitArray(int[] nums, int k) {
        int low =0;
        int high =0;
        for(int len:nums)
        {
            low = Math.max(low,len);
            high += len;
        }
        int ans = high;

        while(low<=high)
        {
            int mid = low +(high-low)/2;
            if(canSplit(nums ,k ,  mid))
            {
                ans = mid;
                high = mid-1;

            }
            else 
            {
                low = mid+1;
            }
        }
        return ans;

   
    }
    
        private boolean canSplit(int[] nums, int k , int max)
        {
            int subarray =1;
            int currentSum =0;
            for(int n:nums)
            {
                if(n+currentSum<=max)
                {
                    currentSum += n;
                }
                else 
                {
                    subarray++;
                    currentSum = n;
                    if(subarray >k)
                    {
                        return false;
                    }
                }
            }
 return true;
        }
       

}
  
}
