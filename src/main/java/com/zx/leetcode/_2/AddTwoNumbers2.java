package com.zx.leetcode._2;

import com.zx.leetcode.common.ListNode;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result;
        ListNode tmp;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int val = tmp1.val + tmp2.val;
        result = new ListNode(val % 10);
        tmp = result;
        boolean needCarry = val >= 10;
        tmp1 = tmp1.next;
        tmp2 = tmp2.next;

        while (tmp1 != null && tmp2 != null) {
            val = needCarry ? tmp1.val + tmp2.val + 1: tmp1.val + tmp2.val;
            tmp.next = new ListNode(val % 10);
            tmp = tmp.next;
            needCarry = val >= 10;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }

        while (tmp1 != null) {
            val = needCarry ? tmp1.val + 1: tmp1.val;
            tmp.next = new ListNode(val % 10);
            tmp = tmp.next;
            needCarry = val >= 10;
            tmp1 = tmp1.next;
        }

        while (tmp2 != null) {
            val = needCarry ? tmp2.val + 1: tmp2.val;
            tmp.next = new ListNode(val % 10);
            tmp = tmp.next;
            needCarry = val >= 10;
            tmp2 = tmp2.next;
        }

        if (needCarry) {
            tmp.next = new ListNode(1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
