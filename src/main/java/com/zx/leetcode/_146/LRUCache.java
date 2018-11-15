package com.zx.leetcode._146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Node head;
    private Node tail;
    private int size;

    private Map<Integer, Node> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.cacheMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = this.head.next;
        node.next.prev = node;
        node.prev = this.head;
        this.head.next = node;



        return node.value;
    }

    public void put(int key, int value) {
        if(this.cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = this.head.next;
            node.next.prev = node;
            node.prev = this.head;
            this.head.next = node;
        } else {
            if(this.capacity == this.size) {
                Node last = this.tail.prev;
                last.prev.next = last.next;
                last.next.prev = last.prev;
                last.next = null;
                last.prev = null;
                //移除最后一个
                this.cacheMap.remove(last.key);
            }
            this.size = this.capacity == this.size ? this.size : this.size + 1;
            Node node = new Node();
            node.key = key;
            node.value = value;
            node.next = this.head.next;
            node.next.prev = node;
            node.prev = this.head;
            this.head.next = node;
            this.cacheMap.put(key, node);
        }

    }

    static class Node{
        private Integer key;
        private Integer value;
        private Node prev;
        private Node next;
    }
}
