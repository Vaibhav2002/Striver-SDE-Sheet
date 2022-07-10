package linkedList2;

import linkedList1.node.ListNode;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">Problem</a>
 **/
public class CheckPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode mid = findMid(head).next;
        mid = reverse(mid);
        ListNode temp = head;
        while(mid!=null){
            if(temp.val != mid.val) return false;
            temp = temp.next;
            mid = mid.next;
        }
        return true;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
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
