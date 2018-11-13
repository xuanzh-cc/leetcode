package com.zx.leetcode._83;

import com.zx.leetcode.common.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        int val = tmp.val;
        while (tmp.next != null) {
            ListNode next = tmp.next;
            int nextVal = next.val;
            if (val == nextVal) {
                tmp.next = next.next;
                next.next = null;
            } else {
                tmp = next;
                val = nextVal;
            }
        }

        return head;
    }
}
