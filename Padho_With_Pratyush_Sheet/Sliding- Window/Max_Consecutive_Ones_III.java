       // Leetcode :- 1004. Max Consecutive Ones III


class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeroCount = 0;
        int result = 0;

        // Expand the window
        for (int right = 0; right < nums.length; right++) {

            // Count zeros in the current window
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Shrink window if zeros exceed k
            while (zeroCount > k) {

                // Remove left element from window
                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            // Update maximum valid window size
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}