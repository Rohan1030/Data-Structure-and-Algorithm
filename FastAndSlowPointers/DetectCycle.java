// Save file as DetectCycle.java
package FastAndSlowPointers;
public class DetectCycle {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Method to detect cycle start
    public static ListNode detectCycle(ListNode head) {

        // Edge case
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // PHASE 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 step
            fast = fast.next.next;    // 2 steps

            if (slow == fast) {
                break; // cycle found
            }
        }

        // If no cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // PHASE 2: Find cycle start
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // cycle starting node
    }

    // MAIN METHOD (for VS Code execution)
    public static void main(String[] args) {

        // Creating linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        //           ^         |
        //           |_________|

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Creating cycle (5 -> 3)
        head.next.next.next.next.next = head.next.next;

        ListNode cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}
