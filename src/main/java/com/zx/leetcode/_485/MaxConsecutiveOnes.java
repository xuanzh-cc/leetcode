package com.zx.leetcode._485;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int max = 0;
        boolean inOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (inOne) {
                    result++;
                } else {
                    result = 1;
                    inOne = true;
                }
            } else {
                if (max < result) {
                    max = result;
                }
                inOne = false;
            }
        }

        return max > result ? max : result;
    }
}
