package linkedList1;

import linkedList1.node.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sum = new ListNode(0), sumEnd = sum;
        ListNode temp1 = l1, temp2 = l2;
        while (temp1 != null || temp2 != null) {
            int s = carry + ((temp1 != null) ? temp1.val : 0) + ((temp2 != null) ? temp2.val : 0);
            sumEnd.next = new ListNode(s % 10);
            carry = s / 10;
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
            sumEnd = sumEnd.next;
        }
        if (carry != 0) sumEnd.next = new ListNode(carry);
        return sum.next;
    }
}
