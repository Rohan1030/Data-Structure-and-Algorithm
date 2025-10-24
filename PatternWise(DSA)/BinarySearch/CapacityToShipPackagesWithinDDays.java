package BinarySearch;
public class CapacityToShipPackagesWithinDDays {


  // Leetcode :- 1011. Capacity To Ship Packages Within D Days

  
class Solution {
    public int shipWithinDays(int[] weights, int days) {

               // Step 1: find search range
        int left =0;
        int right =0;
        for(int w : weights)
        {
            left = Math.max(left,w);
            right +=w;
        }



             // Step 2: binary search for minimum capacity

        while(left<=right)
        {
            int mid = left+(right-left)/2;
            int  reqDay = findDays(weights , mid);
            if(reqDay>days)
            {
                left = mid+1;
            } 
            else 
            {
                right = mid-1;
            }
        }
        return left;








             // Helper function to count days needed for a given capacity
        
    }
    private int findDays(int[] weights , int cap)
    {
        int days = 1;
        int load =0;

        for(int w : weights)
        {
            if(load+w>cap)
            {
                days++;
                load = w;
            }
            else 
            {
                load += w;
            }
        }
        return days;
    }
}



}
