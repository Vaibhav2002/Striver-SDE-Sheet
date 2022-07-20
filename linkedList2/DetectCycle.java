package linkedList2;

import linkedList1.node.ListNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle/">Problem</a>
 **/
public class DetectCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
