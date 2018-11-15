package com.zx.leetcode._2;

import com.zx.leetcode.common.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = reverse(l1);
        ListNode reverseL2 = reverse(l2);
        if (reverseL1 == null) {
            return l2;
        }
        if (reverseL2 == null) {
            return l1;
        }

        int val = reverseL1.val + reverseL2.val;
        ListNode result = new ListNode(val % 10);
        ListNode tmp = result;
        boolean needCarry = val >= 10;
        ListNode tmp1 = reverseL1.next;
        ListNode tmp2 = reverseL2.next;
        while (tmp1 != null || tmp2 != null) {
            if (tmp1 == null) {
                val = needCarry ? tmp2.val + 1 : tmp2.val;
                tmp2 = tmp2.next;
            } else if (tmp2 == null) {
                val = needCarry ? tmp1.val + 1 : tmp1.val;
                tmp1 = tmp1.next;
            } else {
                val = needCarry ? tmp1.val + tmp2.val + 1 : tmp1.val  + tmp2.val;
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            }
            needCarry = val >= 10;
            ListNode next = new ListNode(val % 10);
            tmp.next = next;
            tmp = next;
        }
        if (needCarry) {
            result.next = new ListNode(1);
        }

        return result;
    }

    private ListNode reverse(ListNode node) {
        ListNode parent = null;
        ListNode tmp = node;
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp.next = parent;
            parent = tmp;
            tmp = next;
        }
        return parent;
    }

    private int size(ListNode node) {
        ListNode tmp = node;
        int size = 0;
        while (tmp != null) {
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
