package com.zx.leetcode._167;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int tmp = numbers[start] + numbers[end];
            if (tmp > target) {
                end--;
            } else if (tmp < target) {
                start++;
            } else {
                return new int[]{start + 1, end + 1};
            }
        }
        return null;
    }
}
