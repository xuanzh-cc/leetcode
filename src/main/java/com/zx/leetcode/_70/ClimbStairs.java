package com.zx.leetcode._70;

public class ClimbStairs {
    public int climbStairs(int n) {
        int sum = 0;
        int p1 = n / 2;
        int p2 = n - p1;
        while (p1 > 2 || p2 > 2) {
            if (p1 == 0) {
                sum = sum + climbStairs(p1);
            }
            if (p2 > 0) {
                sum = sum + climbStairs(p2);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int sum = climbStairs.climbStairs(1);
        System.out.println(sum);
    }
}
