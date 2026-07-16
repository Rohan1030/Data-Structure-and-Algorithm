        //  leetcode :- 724. Find Pivot Index

class Solution {
    public int pivotIndex(int[] nums) {

        int totalSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Right sum = Total - Left - Current element
            int rightSum = totalSum - leftSum - nums[i];

            // Check pivot index
            if (leftSum == rightSum) {
                return i;
            }

            // Update left sum
            leftSum += nums[i];
        }

        return -1;
    }
}