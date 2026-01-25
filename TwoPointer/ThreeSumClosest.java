package TwoPointer;
import java.util.*;

public class ThreeSumClosest {

    public static void main(String[] args) {

        // Input array
        int[] nums = {-1, 2, 1, -4};

        // Target value
        int target = 1;

        // Call the function
        int result = threeSumClosest(nums, target);

        // Print the result
        System.out.println("Closest sum to target is: " + result);
    }

    // This function finds the sum of three numbers closest to the target
    public static int threeSumClosest(int[] nums, int target) {

        // Step 1: Sort the array (required for two pointer approach)
        Arrays.sort(nums);

        int n = nums.length;

        // Step 2: Assume first 3 numbers form the closest sum
        int closestSum = nums[0] + nums[1] + nums[2];

        // Step 3: Fix one number one by one
        for (int i = 0; i < n - 2; i++) {

            // Two pointers
            int left = i + 1;        // next element after i
            int right = n - 1;       // last element

            // Step 4: Move pointers until they meet
            while (left < right) {

                // Calculate current sum
                int sum = nums[i] + nums[left] + nums[right];

                // If exact target found, no need to continue
                if (sum == target) {
                    return target;
                }

                // Check if current sum is closer to target
                // Math.abs() gives distance from target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Move pointers based on comparison
                if (sum < target) {
                    left++;    // need bigger sum
                } else {
                    right--;   // need smaller sum
                }
            }
        }

        // Step 5: Return the closest sum found
        return closestSum;
    }
}
