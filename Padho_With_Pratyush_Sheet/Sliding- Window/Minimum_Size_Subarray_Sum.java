class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int low = 0;                     // window start
        int high = 0;                    // window end
        int n = nums.length;
        int sum = 0;                     // window sum
        int result = Integer.MAX_VALUE;  // min length

        while (high < n) {

            sum += nums[high];           // add right element

            while (sum >= target) {
                int length = high - low + 1;
                result = Math.min(result, length);
                sum -= nums[low];        // remove left element
                low++;
            }

            high++;
        }

        if (result == Integer.MAX_VALUE) {
            return 0;                    // no valid subarray
        } else {
            return result;
        }
    }
}