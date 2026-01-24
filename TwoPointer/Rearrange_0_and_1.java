package TwoPointer;
import java.util.*;

public class Rearrange_0_and_1 {

    public static void main(String[] args) {

        int[] arr = {1, 0, 1, 0, 0, 1};

        // rearrange will modify the same array
        rearrange(arr);

        // Print final array
        System.out.println(Arrays.toString(arr));
    }

    // We don't return anything because array is modified in-place
    public static void rearrange(int[] arr) {

        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {

            // If left is already 0 -> correct position
            if (arr[left] == 0) {
                left++;
            }

            // If right is already 1 -> correct position
            else if (arr[right] == 1) {
                right--;
            }

            // If left is 1 and right is 0 -> swap them
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }
}
