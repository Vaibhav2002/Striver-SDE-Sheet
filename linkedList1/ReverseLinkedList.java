package linkedList1;

import linkedList1.node.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">Problem</a>
 **/
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head, prev = null, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
