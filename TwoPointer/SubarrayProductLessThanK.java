package TwoPointer;

import java.util.*;

public class SubarrayProductLessThanK {

    public static void main(String[] args) {

        // Input array
        int[] nums = {10, 5, 2, 6};

        // Target value
        int k = 100;

        // Call the function
        int result = numSubarrayProductLessThanK(nums, k);

        // Print the result
        System.out.println("Number of subarrays with product < k: " + result);
    }

    // This method counts all subarrays whose product is less than k
    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        // If k is 0 or 1, no product can be smaller than k
        if (k <= 1) return 0;

        int left = 0;        // Left pointer of sliding window
        int product = 1;     // Product of elements inside the window
        int count = 0;       // Total number of valid subarrays

        // Right pointer moves from start to end
        for (int right = 0; right < nums.length; right++) {

            // Include current element in the window
            product *= nums[right];

            /*
             * If product becomes >= k,
             * shrink the window from the left
             */
            while (product >= k) {

                /*
                 * Remove the leftmost element's contribution
                 * from the product
                 *
                 * Example:
                 * product = 100
                 * nums[left] = 10
                 * product = 100 / 10 = 10
                 */
                product /= nums[left];

                // Move left pointer forward
                left++;
            }

            /*
             * Number of valid subarrays ending at 'right'
             * is equal to window size:
             * (right - left + 1)
             */
            count += (right - left + 1);
        }

        // Return total count
        return count;
    }
}

