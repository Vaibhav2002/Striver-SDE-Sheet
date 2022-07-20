package linkedList2;

import linkedList1.node.ListNode;

/**
 * <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Problem</a>
 **/
public class FindIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = getLength(headA), l2 = getLength(headB), diff = Math.abs(l1 - l2);
        ListNode temp1 = headA, temp2 = headB;
        if (l1 > l2) temp1 = moveNTimes(temp1, diff);
        else temp2 = moveNTimes(temp2, diff);
        while (temp1 != null && temp2 != null && temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return (temp1 == temp2) ? temp1 : null;
    }

    private int getLength(ListNode head) {
        if (head == null) return 0;
        return 1 + getLength(head.next);
    }

    private ListNode moveNTimes(ListNode head, int n) {
        ListNode temp = head;
        while (temp != null && n-- > 0) temp = temp.next;
        return temp;
    }
}
