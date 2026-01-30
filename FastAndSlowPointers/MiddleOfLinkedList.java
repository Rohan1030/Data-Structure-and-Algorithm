package FastAndSlowPointers;
public class MiddleOfLinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Method to find middle node using fast & slow pointers
    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        /**
         * slow moves 1 step
         * fast moves 2 steps
         *
         * When fast reaches the end,
         * slow will be at the middle
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // middle node
    }

    // MAIN method for VS Code
    public static void main(String[] args) {

        // Creating linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode middle = middleNode(head);

        System.out.println("Middle node value is: " + middle.val);
    }
}
