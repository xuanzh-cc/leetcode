package com.zx.leetcode._896;

public class Monotonic {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        int start = 0;
        while (start < nums.length - 1) {
            if (nums[start] != nums[start + 1]) {
                break;
            }
            start++;
        }
        if (start == nums.length - 1) {
            return true;
        }
        boolean isIncr = nums[start] < nums[start + 1];

        for (int i = start + 1; i < nums.length - 1; i++) {
            if (isIncr && nums[i] > nums[i + 1]) {
                return false;
            } else if (!isIncr && nums[i] < nums[i + 1]){
                return false;
            }
        }

        return true;
    }
}
