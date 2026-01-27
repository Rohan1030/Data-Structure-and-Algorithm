package TwoPointer;
import java.util.*;

public class sortColors {

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(nums));

        sortColors(nums);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(nums));
    }

    // Dutch National Flag Algorithm
    public static void sortColors(int[] nums) {

        int low = 0;                 // position for 0
        int mid = 0;                 // current index
        int high = nums.length - 1;  // position for 2

        while (mid <= high) {

            // Case 1: If current element is 0
            if (nums[mid] == 0) {

                // Swap nums[mid] and nums[low]
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;

                // Move both pointers
                low++;
                mid++;
            }

            // Case 2: If current element is 1
            else if (nums[mid] == 1) {

                // 1 is already in correct position
                mid++;
            }

            // Case 3: If current element is 2
            else {

                // Swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                // Move high pointer only
                high--;

                /*
                 * IMPORTANT:
                 * We do NOT do mid++
                 * because the element swapped from 'high'
                 * is not yet checked.
                 */
                // 👉 A new number comes to index mid

                  // 🔹 Why NOT mid++? (THIS is the key 🔥)

                  // After swapping:

                  // swap(nums[mid], nums[high]);


                  // 👉 A new number comes to index mid

                  // That number could be:

                  // 0

                  // 1

                  // 2

                  // ⚠️ We have NOT checked it yet

                  // So we cannot move mid
            }
        }
    }
}



