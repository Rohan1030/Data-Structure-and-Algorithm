//Leetcode :- 918
package Padho_With_Pratyush_Sheet.Kadane;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int maxAns = nums[0];

        int minSum = nums[0];
        int minAns = nums[0];

        int total = nums[0];

        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            maxAns = Math.max(maxAns, maxSum);

            minSum = Math.min(minSum + nums[i], nums[i]);
            minAns = Math.min(minAns, minSum);  // ✅ min not max

            total += nums[i];
        }

        int case1 = maxAns;
        int case2 = total - minAns;

        if (maxAns > 0) {
            return Math.max(case1, case2);  // ✅ compare both cases
        } else {
            return case1;                   // ✅ all-negatives edge case
        }
    }
}
