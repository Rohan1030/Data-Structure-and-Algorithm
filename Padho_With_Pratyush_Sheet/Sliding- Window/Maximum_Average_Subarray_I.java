    // Leetcode :- 643. Maximum Average Subarray I
  
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int low = 0;
        int high = k - 1;
        int n = nums.length;
        
        long windowSum = 0;
        for (int i = low; i <= high; i++) {
            windowSum += nums[i];
        }
        
        long maxSum = windowSum;
        
        while (high < n - 1) {
            high++;
            windowSum += nums[high];   // add new element FIRST
            windowSum -= nums[low];    // then remove old element (low is still valid here)
            low++;                     // THEN move low forward
            
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return (double) maxSum / k;
    }
}