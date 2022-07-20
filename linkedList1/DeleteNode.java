package linkedList1;

import linkedList1.node.ListNode;

/**
 * <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">Problem</a>
 **/
public class DeleteNode {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
