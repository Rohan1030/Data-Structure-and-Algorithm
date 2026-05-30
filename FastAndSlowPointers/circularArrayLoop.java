package FastAndSlowPointers;
import java.util.*;
public class circularArrayLoop {

    // Main method to check if a circular loop exists
    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        // Try starting from every index
        for (int i = 0; i < n; i++) {

            int slow = i;
            int fast = i;

            // Store initial direction (true = forward, false = backward)
            boolean isForward = nums[i] > 0;

            while (true) {

                // Move slow pointer by 1 step
                slow = nextIndex(nums, slow);

                // Direction check for slow
                if (isForward != (nums[slow] > 0)) break;

                // Move fast pointer by 1 step
                fast = nextIndex(nums, fast);

                // Direction check for fast
                if (isForward != (nums[fast] > 0)) break;

                // Move fast pointer by another step (total 2 steps)
                fast = nextIndex(nums, fast);

                // Direction check again for fast
                if (isForward != (nums[fast] > 0)) break;

                // If slow and fast meet, a cycle may exist
                if (slow == fast) {

                    // Reject self-loop (cycle length = 1)
                    if (slow == nextIndex(nums, slow)) break;

                    return true; // valid cycle found
                }
            }
        }
        return false;
    }

    // Helper function to get next index in circular manner
    private static int nextIndex(int[] nums, int curr) {
        int n = nums.length;

        int index = (curr + nums[curr]) % n;

        // Handle negative modulo
        if (index < 0) index += n;

        return index;
    }

    // MAIN method for VS Code testing
    public static void main(String[] args) {

        int[] nums1 = {2, -1, 1, 2, 2};     // true
        int[] nums2 = {-1, 2};              // false
        int[] nums3 = {-2, 1, -1, -2, -2};  // false

        System.out.println(circularArrayLoop(nums1));
        System.out.println(circularArrayLoop(nums2));
        System.out.println(circularArrayLoop(nums3));
    }
}
