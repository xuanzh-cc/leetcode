package com.zx.leetcode._23;

import com.zx.leetcode.common.ListNode;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }

        SmallHeap heap = new SmallHeap(lists.length);
        for (int i = 0; i < lists.length; i++) {
            heap.insert(lists[i]);
        }

        if (heap.size <= 0) {
            return null;
        }

        ListNode result = heap.removeTop();
        ListNode tmp = result;
        if (result.next != null) {
            heap.insert(result.next);
        }
        while (heap.size > 0) {
            ListNode next = heap.removeTop();
            tmp.next = next;
            tmp = next;
            if (next.next != null) {
                heap.insert(next.next);
            }
        }

        return result;
    }

    static class SmallHeap {
        // 第一个位置不存放元素
        // leftChild = 2*i
        // rightChild = 2*i + 1
        private ListNode[] data;
        private int capacity;
        private int size;

        public SmallHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.data = new ListNode[capacity + 1];
        }

        private void insert(ListNode node) {
            if (node == null) {
                return;
            }
            if (size >= capacity) {
                throw new RuntimeException("heap if full");
            }
            size++;
            data[size] = node;
            shiftUp(size);
        }

        private ListNode removeTop() {
            ListNode top = data[1];
            data[1] = data[size];
            size--;
            shiftDown(1);
            return top;
        }

        /**
         * 自底向上调整堆
         * @param offset
         */
        private void shiftUp(int offset) {
            while (offset > 1) {
                int parentOffset = offset / 2;
                ListNode parent = data[parentOffset];
                ListNode node = data[offset];
                if (parent.val > node.val) {
                    ListNode tmp = data[parentOffset];
                    data[parentOffset] = node;
                    data[offset] = tmp;
                }
                offset = parentOffset;
            }
        }

        /**
         * 自顶向下调整堆
         * @param offset
         */
        private void shiftDown(int offset) {
            while (offset * 2 <= size) {
                int leftChildOffset = offset * 2;
                int rightChildOffset = offset * 2 + 1;
                int minOffset = data[offset].val <= data[leftChildOffset].val ? offset : leftChildOffset;
                if (rightChildOffset <= size) {
                    minOffset = data[minOffset].val <= data[rightChildOffset].val ? minOffset : rightChildOffset;
                }
                if (minOffset == offset) {
                    break;
                } else {
                    ListNode tmp = data[offset];
                    data[offset] = data[minOffset];
                    data[minOffset] = tmp;
                    offset = minOffset;
                }
            }

        }
    }

    public static void main(String[] args) {
        //[[1,4,5],[1,3,4],[2,6]]
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1);
        listNodes[0].next = new ListNode(4);
        listNodes[0].next.next = new ListNode(5);

        listNodes[1] = new ListNode(1);
        listNodes[1].next = new ListNode(3);
        listNodes[1].next.next = new ListNode(4);

        listNodes[2] = new ListNode(2);
        listNodes[2].next = new ListNode(6);
        ListNode result = new MergeKLists().mergeKLists(listNodes);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
