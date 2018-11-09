package com.zx.leetcode._88;

import static com.zx.leetcode.common.util.Utils.printArr;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = 0;
        int l2 = 0;
        while (l1 < m || l2 < n) {
            if (l1 < m && l2 < n) {
                if (nums1[l1] < nums2[l2]) {
                    l1++;
                } else if (nums1[l1] >= nums2[l2]) {
                    for (int i = m - 1; i >= l1; i--) {
                        nums1[i + 1] = nums1[i];
                    }
                    nums1[l1] = nums2[l2];
                    l2++;
                    l1++;
                    m++;
                }
            } else if (l2 < n) {
                nums1[m] = nums2[l2];
                l2++;
                l1++;
                m++;
            } else {
                l1++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        new Merge().merge(arr, 1, new int[]{}, 0);
        printArr(arr);
    }
}
