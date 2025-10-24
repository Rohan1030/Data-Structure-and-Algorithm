package BinarySearch;

public class SearchinRotatedSortedArray {



        // Leetcode :- 33 

  class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left=0;
        int right =n-1;

        while(left<=right)
        {
            int mid = left+(right-left)/2;

            if(nums[mid]==target)
            return mid;

            // left sorted 

            if(nums[left]<= nums[mid])
            {
                if(nums[left]<=target && target <nums[mid]) // target is between nums[left] and nums[mid]
                {
                    right = mid-1;

                }
                else 
                {
                    left = mid+1;
                }
            }
            // Right sorted
            else 
            {
                if(nums[mid]<target && target <= nums[right]) // target is between nums[mid] and nums[right]
                {
                    left = mid+1;
                }
                else 
                {
                    right = mid-1;

                }
            }

        }
        return -1;

        
    }
}
  
}
