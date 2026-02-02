public class ReorderList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void reorderList(ListNode head) {

        // Base case: empty list or single node
        if (head == null || head.next == null) return;

        // STEP 1: Find middle using fast & slow pointers
        ListNode slow = head;
        ListNode fast = head;

        // fast moves 2 steps, slow moves 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // STEP 2: Reverse the second half
        // IMPORTANT: reverse from slow.next (not slow)
        ListNode second = reverse(slow.next);

        // Cut the list into two halves
        slow.next = null;

        // STEP 3: Merge first half and reversed second half
        ListNode first = head;

        while (second != null) {
            // Save next pointers
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            // Reorder links
            first.next = second;
            second.next = t1;

            // Move pointers forward
            first = t1;
            second = t2;
        }
    }

    // Reverse a linked list using curr pointer
    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // save next
            curr.next = prev;          // reverse link
            prev = curr;               // move prev
            curr = next;               // move curr
        }

        return prev; // new head after reverse
    }

    // MAIN method for VS Code testing
    public static void main(String[] args) {

        // Example: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);

        // Print reordered list
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
