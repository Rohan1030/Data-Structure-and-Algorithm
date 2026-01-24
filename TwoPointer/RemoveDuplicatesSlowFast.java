package TwoPointer;
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class RemoveDuplicatesSlowFast {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of nodes
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Empty List");
            return;
        }

        // Create linked list
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        // Remove duplicates using slow & fast
        head = removeDuplicates(head);

        // Print result
        printList(head);

        sc.close();
    }

    // ✅ ONLY TWO POINTERS: slow and fast
    public static ListNode removeDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        // slow points to last unique node
        ListNode slow = head;

        // fast checks upcoming nodes
        ListNode fast = head.next;

        while (fast != null) {

            // ✅ Duplicate found -> move fast only
            if (slow.val == fast.val) {
                fast = fast.next;
            }
            // ✅ New unique found -> connect slow to fast
            else {
                slow.next = fast;   // keep only unique node
                slow = fast;        // move slow forward
                fast = fast.next;   // move fast forward
            }
        }

        // cut remaining duplicate links (important)
        slow.next = null;

        return head;
    }

    // Print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
