package linkedListAndArray;

import linkedList1.node.ListNode;

/**
 * <a href="https://leetcode.com/problems/rotate-list/">Problem</a>
 **/
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = getLength(head);
        k = k % len;
        ListNode slow = head, fast = head;
        while (k-- > 0) fast = fast.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    private int getLength(ListNode head) {
        if (head == null) return 0;
        return 1 + getLength(head.next);
    }
}
