package com.zx.leetcode._24;

import com.zx.leetcode.common.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode parent = null;
        ListNode tmp = head;
        ListNode tmpNext = tmp.next;
        while (tmp != null && tmpNext != null) {
            ListNode next = tmpNext.next;
            tmpNext.next = tmp;
            tmp.next = next;
            if (parent != null) {
                parent.next = tmpNext;
            } else {
                head = tmpNext;
            }
            parent = tmp;
            if (next == null) {
                break;
            }
            tmp = next;
            tmpNext = next.next;
        }

        return head;
    }
}
