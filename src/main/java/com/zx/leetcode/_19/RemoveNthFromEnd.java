package com.zx.leetcode._19;

import com.zx.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        if (n == 0 || n > list.size()) {
            return head;
        }

        int remIndex = list.size() - n;
        if (remIndex == 0) {
            tmp = head;
            head = head.next;
            tmp.next = null;
            return head;
        }
        ListNode rem = list.get(remIndex);
        ListNode prev = list.get(remIndex - 1);
        prev.next = rem.next;
        rem.next = null;
        return head;
    }
}
