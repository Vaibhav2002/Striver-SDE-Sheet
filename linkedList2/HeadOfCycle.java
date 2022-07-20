package linkedList2;

import linkedList1.node.ListNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle-ii/">Problem</a>
 **/
public class HeadOfCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
        } while (slow != fast);
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
