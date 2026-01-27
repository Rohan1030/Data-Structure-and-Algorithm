package TwoPointer;
import java.util.*;

public class FourSum {

    public static void main(String[] args) {

        // Input array
        int[] nums = {1, 0, -1, 0, -2, 2};

        // Target sum
        int target = 0;

        // Call the 4Sum function
        List<List<Integer>> result = fourSum(nums, target);

        // Print the result
        System.out.println("Quadruplets with target sum:");
        for (List<Integer> quad : result) {
            System.out.println(quad);
        }
    }

    /*
     * This method finds all unique quadruplets
     * whose sum is equal to the given target.
     *
     * Data Structure Used:
     * - List<List<Integer>> to store multiple quadruplets
     * - Each quadruplet is stored as List<Integer>
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        // This list will store the final answer
        List<List<Integer>> res = new ArrayList<>();

        // Sort the array to use two-pointer approach
        Arrays.sort(nums);
        int n = nums.length;

        // Step 1: Fix the first element
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate values for first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Step 2: Fix the second element
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate values for second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Step 3: Two pointers for remaining two elements
                int left = j + 1;       // third element
                int right = n - 1;      // fourth element

                // Step 4: Move pointers until they cross
                while (left < right) {

                    /*
                     * Use long to avoid integer overflow
                     * while adding four numbers
                     */
                    long sum = (long) nums[i]
                             + nums[j]
                             + nums[left]
                             + nums[right];

                    // If sum matches target, store the quadruplet
                    if (sum == target) {

                        res.add(Arrays.asList(
                                nums[i], nums[j], nums[left], nums[right]
                        ));

                        // Move both pointers
                        left++;
                        right--;

                        // Skip duplicate values for left pointer
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicate values for right pointer
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                    // If sum is smaller, move left pointer to increase sum
                    else if (sum < target) {
                        left++;
                    }
                    // If sum is larger, move right pointer to decrease sum
                    else {
                        right--;
                    }
                }
            }
        }

        // Return all unique quadruplets
        return res;
    }
}
