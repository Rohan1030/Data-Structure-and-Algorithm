package TwoPointer;
import java.util.*;

public class Two_Sum_Input_Array_Is_Sorted {

    public static void main(String[] args) {

        // Given sorted array
        int[] numbers = {2, 7, 11, 15};

        // Target sum we want to find
        int target = 9;

        // Calling Sum() method
        // NOTE: Sum() returns an int[] (array) which stores two indexes
        int[] result = Sum(numbers, target);

        // Printing result array in proper format
        // Arrays.toString() helps print [1, 2] instead of some memory address
        System.out.println(Arrays.toString(result));
    }

    // This method finds two numbers whose sum = target
    // and returns their indices in 1-based indexing (as per LeetCode question)
    public static int[] Sum(int[] numbers, int target) {

        // Total number of elements in array
        int n = numbers.length;

        // left pointer starts from beginning
        int left = 0;

        // right pointer starts from end
        int right = n - 1;

        // Loop until both pointers meet
        while (left < right) {

            // Calculate sum of elements at left and right pointers
            int sum = numbers[left] + numbers[right];

            // ✅ If sum matches target -> return indices (1-based indexing)
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            // ❌ If sum is greater than target
            // then we need a smaller sum
            // since array is sorted, decreasing right will reduce sum
            else if (sum > target) {
                right--;
            }

            // ❌ If sum is smaller than target
            // then we need a larger sum
            // since array is sorted, increasing left will increase sum
            else {
                left++;
            }
        }

        // If no pair found, return [-1, -1]
        return new int[]{-1, -1};
    }
}
