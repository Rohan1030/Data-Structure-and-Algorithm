package FastAndSlowPointers;

public class PalindromeLinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static boolean isPalindrome(ListNode head) {

        // Base case: empty or single node
        if (head == null && head.next == null) {
            return true;
        }

        // Find middle using fast & slow pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Skip middle node for odd-length list
        if (fast != null) {
            slow = slow.next;
        }

        // Reverse second half
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        // Compare both halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Reverse a linked list
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    // MAIN method for VS Code testing
    public static void main(String[] args) {

        // Example: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println("Is Palindrome? " + isPalindrome(head));
    }
}
