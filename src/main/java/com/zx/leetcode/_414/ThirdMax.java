package com.zx.leetcode._414;

public class ThirdMax {
    // 2 2 3 1
    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer sMax = null;
        Integer tMax = null;
        for (int i = 0; i < nums.length; i++) {
            if (max == null || nums[i] > max) {
                tMax = sMax;
                sMax = max;
                max = nums[i];
            } else if (nums[i] != max && ( sMax == null || nums[i] > sMax)) {
                tMax = sMax;
                sMax = nums[i];
            } else if (nums[i] != max && nums[i] != sMax && (tMax == null || nums[i] > tMax)) {
                tMax = nums[i];
            }
        }

        return tMax == null ? max : tMax;
    }

    public static void main(String[] args) {
        System.out.println(new ThirdMax().thirdMax(new int[]{1,2}));
    }
}
