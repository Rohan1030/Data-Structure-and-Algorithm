package TwoPointer;

public class Squares_of_a_Sorted_Array {

    public static int[] sortedSquares(int[] nums) {

        int n = nums.length;

        // Result array to store sorted squares
        int[] result = new int[n];

        // left pointer -> start of array
        int left = 0;

        // right pointer -> end of array
        int right = n - 1;

        // pos -> position to fill in result array
        // We start from the END because biggest square comes first
        int pos = n - 1;

        // Run until both pointers cross
        while (left <= right) {

            // Square of left and right elements
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            // Compare squares and place the bigger one at result[pos]
            if (leftSquare > rightSquare) {
                result[pos] = leftSquare; // put bigger square
                left++;                  // move left pointer
            } else {
                result[pos] = rightSquare; // put bigger square
                right--;                   // move right pointer
            }

            // Move backwards because we are filling from the end
            pos--;
        }

        // Return the sorted squares array
        return result;
    }

    // Just for testing in VS Code
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};

        int[] ans = sortedSquares(nums);

        // Print result
        System.out.print("Sorted Squares: ");
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
