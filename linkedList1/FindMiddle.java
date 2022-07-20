package linkedList1;

import linkedList1.node.ListNode;

/**
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">Problem</a>
 **/
public class FindMiddle {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != null && fast.next != null);
        return slow;
    }
}
