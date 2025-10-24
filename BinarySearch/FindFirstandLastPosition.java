package BinarySearch;

public class FindFirstandLastPosition {



      // Leetcode:- 34

  class Solution {
    public int[] searchRange(int[] nums, int target) {

            int first = findFirst(nums,target);
            int Last = findLast(nums,target);
            return  new  int[]{first,Last};



    }




        private int findFirst(int[] nums , int target)
        {
            if(nums==null && nums.length ==0) return -1;
            int n = nums.length;
            int left=0;
            int right = n-1;
            int ans =-1;
            while(left<=right)
            {
                int mid = left +(right-left)/2;
                
                if(nums[mid]==target)
                {
                    ans = mid;
                    right=mid-1; // left side searching
                }
                else if(target>nums[mid])
                {
                    left=mid+1;
                }
                else 
                {
                    right=mid-1;
                }

            }
            return ans;


        }


         private int findLast(int[] nums , int target)
        {
            if(nums==null && nums.length ==0) return -1;
            int n = nums.length;
            int left=0;
            int right = n-1;
            int ans =-1;
            while(left<=right)
            {
                int mid = left +(right-left)/2;
                
                if(nums[mid]==target)
                {
                    ans = mid;
                    left=mid+1; // right side searching
                }
                else if(target>nums[mid])
                {
                    left=mid+1;
                }
                else 
                {
                    right=mid-1;
                }

            }
            return ans;


        }




        
        
    
}
  
}
