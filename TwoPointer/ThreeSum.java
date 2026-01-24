package TwoPointer;
import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        // Given array
        int[] nums = {-1, 0, 1, 2, -1, -4};

        // Call the 3Sum function
        List<List<Integer>> result = threeSum(nums);

        // Print the result
        System.out.println("Triplets with sum 0:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }

    // This method finds all unique triplets whose sum is zero
    public static List<List<Integer>> threeSum(int[] nums) {

        // This will store the final answer (list of triplets)
        List<List<Integer>> res = new ArrayList<>();

        // Step 1: Sort the array (required for two pointer approach)
        Arrays.sort(nums);

        // Fix the first element one by one
        for (int i = 0; i < nums.length - 2; i++) {

            // If current number is same as previous, skip it to avoid duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Optimization:
            // If the fixed number is greater than 0,
            // then remaining numbers will also be > 0
            // so sum can never be zero
            if (nums[i] > 0) {
                break;
            }

            // Two pointers
            int left = i + 1;              // pointer just after i
            int right = nums.length - 1;   // pointer at the end

            // Move pointers until they cross
            while (left < right) {

                // Calculate sum of three numbers
                int sum = nums[i] + nums[left] + nums[right];

                // If sum is exactly zero → valid triplet found
                if (sum == 0) {

                    // Add the triplet to result
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move both pointers
                    left++;
                    right--;

                    // Skip duplicate values on the left side
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate values on the right side
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                }
                // If sum is less than zero, we need a bigger value
                else if (sum < 0) {
                    left++;
                }
                // If sum is greater than zero, we need a smaller value
                else {
                    right--;
                }
            }
        }

        // Return all unique triplets
        return res;
    }
}
