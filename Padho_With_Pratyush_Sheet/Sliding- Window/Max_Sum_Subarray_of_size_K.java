class Solution {
    public int maxSubarraySum(int[] arr, int k) {

        int n = arr.length;

        if (n < k) return 0; // invalid window

        int low = 0;       // window start
        int high = k - 1;  // window end
        int sum = 0;       // current window sum
        int result = 0;    // max sum

        // first window sum
        for (int i = low; i <= high; i++) {
            sum += arr[i];
        }

        result = sum;

        // slide window till end
        while (high < n - 1) {
            sum -= arr[low];  // remove left
            low++;
            high++;
            sum += arr[high]; // add right
            result = Math.max(result, sum);
        }

        return result;
    }
}