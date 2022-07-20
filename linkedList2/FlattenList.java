package linkedList2;

/**
 * <a href="https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1">Problem</a>
 **/
public class FlattenList {
    Node flatten(Node root) {
        if (root == null || root.next == null) return root;
        var right = flatten(root.next);
        return merge(root, right);
    }

    Node merge(Node head1, Node head2) {
        Node dummy = new Node(0), dummyEnd = dummy;
        Node temp = head1, temp2 = head2;
        while (temp != null && temp2 != null) {
            if (temp.data < temp2.data) {
                dummyEnd.bottom = temp;
                temp = temp.bottom;
            } else {
                dummyEnd.bottom = temp2;
                temp2 = temp2.bottom;
            }
            dummyEnd = dummyEnd.bottom;
        }
        if (temp != null) dummyEnd.bottom = temp;
        if (temp2 != null) dummyEnd.bottom = temp2;
        return dummy.bottom;
    }

    private static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }
}
