package com.zx.leetcode._141;

import com.zx.leetcode.common.ListNode;

public class CycleLink {
    public boolean hasCycle(ListNode head) {
//        Set<ListNode> visited = new HashSet<>();
//        ListNode tmp = head;
//        while (tmp != null) {
//            if (visited.contains(tmp)) {
//                return true;
//            } else {
//                visited.add(tmp);
//                tmp = tmp.next;
//            }
//        }
//        return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
