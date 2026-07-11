package Padho_With_Pratyush_Sheet.Kadane;

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int bestEnding = nums[0];
        int ans = bestEnding;
        for(int i=1;i<n;i++)
        {
            int v1 = bestEnding +nums[i];
            int v2 = nums[i];



            bestEnding = Math.max(v1,v2);
            ans = Math.max(bestEnding , ans );

        }
        return ans;

        
    }
}