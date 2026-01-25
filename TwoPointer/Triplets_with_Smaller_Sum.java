package TwoPointer;
import java.util.*;

public class Triplets_with_Smaller_Sum {

    public static void main(String[] args) {

        // Input array
        int[] nums = {-1, 0, 2, 3};

        // Target sum
        int target = 3;

        // Call the function
        int result = tripletSum(nums, target);

        // Print number of valid triplets
        System.out.println(result);
    }

    // This method counts all triplets whose sum is smaller than target
    public static int tripletSum(int[] nums, int target) {

        // Step 1: Sort the array (required for two-pointer approach)
        Arrays.sort(nums);

        int n = nums.length;

        // This will store the final count of valid triplets
        int count = 0;

        // Step 2: Fix the first element of the triplet
        for (int i = 0; i < n - 2; i++) {

            // Two pointers for the remaining two elements
            int left = i + 1;      // element just after i
            int right = n - 1;     // last element

            // Step 3: Move pointers until they cross
            while (left < right) {

                // Calculate sum of current triplet
                int sum = nums[i] + nums[left] + nums[right];

                // If sum is smaller than target
                if (sum < target) {

                    /*
                     * IMPORTANT:
                     * Since the array is sorted, all elements between
                     * left and right will also form valid triplets.
                     * So we add (right - left) to the count at once.
                     */
                    count += (right - left);

                    // Move left pointer to check new combinations
                    left++;
                } 
                // If sum is greater than or equal to target
                else {
                    // Move right pointer to reduce the sum
                    right--;
                }
            }
        }

        // Step 4: Return total count of valid triplets
        return count;
    }
}
