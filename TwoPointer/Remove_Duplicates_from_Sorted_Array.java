package TwoPointer;

import java.util.Arrays;

public class Remove_Duplicates_from_Sorted_Array {

    // Function to remove duplicates from sorted array
    // and return count of unique elements
    public static int removeDuplicates(int[] nums) {

        // If array is empty, no elements are there
        if (nums.length == 0) return 0;

        // slow pointer -> points to last unique element index
        int slow = 0;

        // fast pointer -> checks every element from index 1
        for (int fast = 1; fast < nums.length; fast++) {

            // If current element is different from last unique element
            // it means we found a NEW UNIQUE element
            if (nums[fast] != nums[slow]) {

                // move slow to next position
                slow++;

                // place the new unique element at slow position
                nums[slow] = nums[fast];
            }
        }

        // slow is index, so unique count = slow + 1
        return slow + 1;
    }

    public static void main(String[] args) {

        // Example Input
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};

        // calling function
        int k = removeDuplicates(nums);

        // Printing k (unique count)
        System.out.println("Unique count (k) = " + k);

        // Printing only unique part of array
        System.out.print("Unique array = ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

        // Optional: print full array to see changes
        System.out.println("\nFull array after operation = " + Arrays.toString(nums));
    }
}
