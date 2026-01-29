package FastAndSlowPointers;
import java.util.*;
public class LinkedListCycle {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

        /*
         * Create linked list:
         * 3 -> 2 -> 0 -> -4
         *      ^         |
         *      |_________|
         * Cycle starts at node with value 2
         */

        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // creates a cycle

        boolean result = hasCycle(head);

        System.out.println("Does the linked list have a cycle? " + result);
    }

    /*
     * This method checks whether a linked list has a cycle.
     * Uses Floyd’s Cycle Detection Algorithm (Slow & Fast pointers).
     */
    public static boolean hasCycle(ListNode head) {

        // If list is empty or has only one node, no cycle possible
        if (head == null || head.next == null) {
            return false;
        }

        // Slow and fast pointers start from head
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {

            slow = slow.next;           // move slow by 1 step
            fast = fast.next.next;      // move fast by 2 steps

            // If slow and fast meet, cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches null, no cycle
        return false;
    }
}
