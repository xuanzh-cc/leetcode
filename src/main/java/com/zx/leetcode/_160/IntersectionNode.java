package com.zx.leetcode._160;

import com.zx.leetcode.common.ListNode;

public class IntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0;
        ListNode tmpA = headA;

        while (tmpA != null) {
            lenA++;
            tmpA = tmpA.next;
        }
        tmpA = headA;

        int lenB = 0;
        ListNode tmpB = headB;
        while (tmpB != null) {
            lenB++;
            tmpB = tmpB.next;
        }
        tmpB = headB;

        if (lenA > lenB) {
            while (lenA > lenB) {
                lenA--;
                tmpA = tmpA.next;
            }
        }

        if (lenA < lenB) {
            while (lenA < lenB) {
                lenB--;
                tmpB = tmpB.next;
            }
        }

        while (tmpA != null && tmpA != tmpB) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }

        return tmpA;

    }

    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(1);
        listNodeA.next = new ListNode(3);
        ListNode listNodeB = null;

        getIntersectionNode(listNodeA, listNodeB);
    }
}
