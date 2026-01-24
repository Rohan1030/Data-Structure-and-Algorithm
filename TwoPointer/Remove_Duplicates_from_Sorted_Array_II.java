package TwoPointer;

import java.util.Arrays;

public class Remove_Duplicates_from_Sorted_Array_II {

    // This function removes duplicates but allows max 2 occurrences of each element
    public static int removeDuplicates(int[] nums) {

        int n = nums.length;

        // If array length is 2 or less, nothing to remove
        if (n <= 2) return n;

        // slow pointer tracks where to place valid elements
        int slow = 2;  // first two elements are always allowed

        // fast pointer checks elements from index 2
        for (int fast = 2; fast < n; fast++) {

            // Condition:
            // We compare current element nums[fast] with nums[slow - 2]
            // If they are different, it means we can keep this element
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];  // place element
                slow++;                   // move slow
            }
        }

        // slow is the count of valid elements
        return slow;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};

        int k = removeDuplicates(nums);

        System.out.println("k = " + k);

        System.out.print("Array after removing duplicates (max 2 allowed): ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println("\nFull array = " + Arrays.toString(nums));
    }
}
