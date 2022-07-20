package linkedList1;

import linkedList1.node.ListNode;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Problem</a>
 **/
public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode temp1 = head1, temp2 = head2;
        ListNode dummy = new ListNode(0), dummyEnd = dummy;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                dummyEnd.next = temp1;
                temp1 = temp1.next;
            } else {
                dummyEnd.next = temp2;
                temp2 = temp2.next;
            }
            dummyEnd = dummyEnd.next;
        }
        if (temp1 != null) dummyEnd.next = temp1;
        if (temp2 != null) dummyEnd.next = temp2;
        return dummy.next;
    }
}
