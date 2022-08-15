package stackAndQueue2;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/lru-cache/">Problem</a>
 **/
public class LRUCache {

    private static class Node {
        int key, val;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = prev = null;
        }
        public Node(int key, int val, Node prev, Node next){
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private final Node head;
    private final Node tail;
    HashMap<Integer, Node> map;
    int maxSize;

    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>(capacity);
        maxSize = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        var node = map.get(key);
        delete(node);
        insertNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        var node = new Node(key, value, head, head.next);
        if (!map.containsKey(key)) insertWhenNotExists(node);
        else insertWhenExists(node);
    }

    private void insertWhenNotExists(Node node) {
        if (map.size() == maxSize) delete(tail.prev);
        insertNode(node);
    }

    private void insertWhenExists(Node node){
        delete(map.get(node.key));
        insertNode(node);
    }

    private void insertNode(Node node){
        map.put(node.key, node);
        head.next.prev = node;
        head.next = node;
    }

    private void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

    public static void main(String[] args) {
        LRUCache ob = new LRUCache(2);
        ob.put(1, 1);
        ob.put(2, 2);
        ob.get(1);
        ob.put(3, 3);
        ob.get(2);
        ob.put(4, 4);
        ob.get(1);
        ob.get(3);
        ob.get(4);
    }
}
