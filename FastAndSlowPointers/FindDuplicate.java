package FastAndSlowPointers;

public class FindDuplicate {

    /**
     * This method finds the duplicate number in the array
     * using Floyd's Tortoise and Hare (Fast & Slow Pointer) algorithm.
     *
     * Key idea:
     * - Treat the array as a linked list
     * - index -> node
     * - nums[index] -> next pointer
     * - Duplicate value creates a cycle
     */
    public static int findDuplicate(int[] nums) {

        // Initialize both pointers to the first value
        // (start of the "linked list")
        int slow = nums[0];
        int fast = nums[0];

        System.out.println("PHASE 1: Detect Cycle");
        System.out.println("----------------------");

        /**
         * PHASE 1:
         * Move slow pointer by 1 step
         * Move fast pointer by 2 steps
         *
         * If there is a cycle, both pointers will meet
         */
        do {
            slow = nums[slow];          // move slow by 1 step
            fast = nums[nums[fast]];    // move fast by 2 steps

            System.out.println("slow = " + slow + ", fast = " + fast);

        } while (slow != fast);

        // At this point, slow and fast have met inside the cycle
        System.out.println("\nPointers met at: " + slow);

        System.out.println("\nPHASE 2: Find Duplicate");
        System.out.println("----------------------");

        /**
         * PHASE 2:
         * Reset slow pointer to the start (nums[0])
         * Keep fast pointer at the meeting point
         *
         * Move both pointers ONE step at a time.
         * The point where they meet again is the
         * entrance of the cycle -> duplicate number
         */
        slow = nums[0];
        System.out.println("Reset slow to start: " + slow);

        while (slow != fast) {
            slow = nums[slow];    // move slow by 1 step
            fast = nums[fast];    // move fast by 1 step

            System.out.println("slow = " + slow + ", fast = " + fast);
        }

        // slow (or fast) now points to the duplicate number
        return slow;
    }

    public static void main(String[] args) {

        // Example input:
        // Duplicate number = 2
        int[] nums = {1, 3, 4, 2, 2};

        int duplicate = findDuplicate(nums);

        System.out.println("\nDuplicate number is: " + duplicate);
    }
}
