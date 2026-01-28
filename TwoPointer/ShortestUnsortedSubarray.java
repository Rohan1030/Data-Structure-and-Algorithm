package TwoPointer;
import java.util.*;

public class ShortestUnsortedSubarray {

    public static void main(String[] args) {

        // Test input
        int[] nums = {2, 6, 4, 8, 10, 9, 15};

        // Call the function
        int result = findUnsortedSubarray(nums);

        // Print result
        System.out.println("Length of shortest unsorted subarray: " + result);
    }

    /*
     * This method finds the length of the shortest continuous subarray
     * such that sorting only this subarray makes the whole array sorted.
     *
     * Approach:
     * - Scan from left to right to find the right boundary
     * - Scan from right to left to find the left boundary
     */
    public static int findUnsortedSubarray(int[] nums) {

        int n = nums.length;

        // These will store the boundaries of the unsorted subarray
        int left = -1;
        int right = -1;

        // Variables to track max from left and min from right
        int maxFromLeft = nums[0];
        int minFromRight = nums[n - 1];

        /*
         * Step 1: Traverse from left to right
         * If we find a number smaller than the max so far,
         * it means array is not sorted at this position.
         */
        for (int i = 1; i < n; i++) {
            if (nums[i] < maxFromLeft) {
                right = i;   // update right boundary
            } else {
                maxFromLeft = nums[i];
            }
        }

        /*
         * Step 2: Traverse from right to left
         * If we find a number greater than the min so far,
         * it means array is not sorted at this position.
         */
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > minFromRight) {
                left = i;    // update left boundary
            } else {
                minFromRight = nums[i];
            }
        }

        // Step 3: If array is already sorted
        if (left == -1) {
            return 0;
        }

        // Step 4: Length of the unsorted subarray
        return right - left + 1;
    }
}
