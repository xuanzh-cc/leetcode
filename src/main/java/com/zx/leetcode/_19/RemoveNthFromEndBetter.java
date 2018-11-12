package com.zx.leetcode._19;

import com.zx.leetcode.common.ListNode;

public class RemoveNthFromEndBetter {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode slower = head;
        ListNode fast = head;
        while (n-- > 0) {
            if (fast.next == null) {
                return head.next;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slower = slower.next;
        }
        slower.next = slower.next.next;
        return head;
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        System.out.println(m--);
        System.out.println(m);
        while (n-- > 0) {
            System.out.println(n);
        }
    }
}
