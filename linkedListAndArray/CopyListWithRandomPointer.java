package linkedListAndArray;

/**
 * <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">Problem</a>
 **/
public class CopyListWithRandomPointer {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        insertCopyNodes(head);
        copyRandomPointer(head);
        return extractCopyList(head);
    }

    private void insertCopyNodes(Node head) {
        Node temp = head;
        while (temp != null) {
            var newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
    }

    private void copyRandomPointer(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
    }

    private Node extractCopyList(Node head) {
        Node temp = head, copy = new Node(0), copyEnd = copy;
        while (temp != null) {
            copyEnd.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            copyEnd = copyEnd.next;
        }
        return copy.next;
    }
}
