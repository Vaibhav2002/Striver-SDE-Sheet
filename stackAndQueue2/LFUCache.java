package stackAndQueue2;

import java.util.HashMap;

public class LFUCache {

    private static class Node {
        int key, val, freq;
        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
            next = prev = null;
        }

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public void incFreq() {
            freq++;
        }
    }

    private static class DLL {
        Node head, tail;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        private void insert(Node node) {
            node.next = head.next;
            node.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        private void delete(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private boolean isEmpty() {
            return head.next == tail && tail.prev == head;
        }
    }

    HashMap<Integer, DLL> list;
    HashMap<Integer, Node> cache;
    int size, minFreq;

    public LFUCache(int capacity) {
        list = new HashMap<>();
        cache = new HashMap<>();
        size = capacity;
        minFreq = 1;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        var node = cache.get(key);
        remove(node);
        node.incFreq();
        insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) putIfExists(cache.get(key), value);
        else putIfNotExists(new Node(key, value));
    }

    private void putIfExists(Node node, int newVal) {
        remove(node);
        node.val = newVal;
        node.incFreq();
        insert(node);
    }

    private void putIfNotExists(Node node) {
        if (cache.size() == size) remove(list.get(minFreq).tail.prev);
        insert(node);
        minFreq = 1;
    }

    private void insert(Node node) {
        if (!list.containsKey(node.freq)) list.put(node.freq, new DLL());
        list.get(node.freq).insert(node);
        cache.put(node.key, node);
    }

    private void remove(Node node) {
        list.get(node.freq).delete(node);
        cache.remove(node.key);
        if (list.get(minFreq).isEmpty()) minFreq++;
    }

    public static void main(String[] args) {
        LFUCache ob = new LFUCache(3);
        ob.put(2, 2);
        ob.put(1, 1);
        ob.get(2);
        ob.get(1);
        ob.get(2);
        ob.put(3, 3);
        ob.put(4, 4);
        ob.get(3);
        ob.get(2);
        ob.get(1);
        ob.get(4);
    }
}
