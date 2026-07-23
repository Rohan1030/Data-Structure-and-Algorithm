    //  Gfg: Check Sorted Array


class Solution {

    public boolean isSorted(int[] arr) {

        // Start checking from index 0
        return Sorted(arr, 0);
    }

    // Recursive function
    boolean Sorted(int[] arr, int i) {

        // Base case: reached the last element
        if (i == arr.length - 1) {
            return true;
        }

        // If current element is greater than next
        if (arr[i] > arr[i + 1]) {
            return false;
        }

        // Check the remaining array
        return Sorted(arr, i + 1);
    }
}