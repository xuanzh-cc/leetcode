package com.zx.leetcode._441;

public class ArrangeCoins {
    public int arrangeCoins(int n) {
        int num = 0;
        int left = n;
        while (true) {
            left = left - num;
            if (left >= num + 1) {
                num++;
            } else {
                return num;
            }
        }
    }

    public static void main(String[] args) {
        ArrangeCoins arrangeCoins = new ArrangeCoins();
        System.out.println(arrangeCoins.arrangeCoins(1));
        System.out.println(arrangeCoins.arrangeCoins(2));
        System.out.println(arrangeCoins.arrangeCoins(3));
        System.out.println(arrangeCoins.arrangeCoins(5));
        System.out.println(arrangeCoins.arrangeCoins(6));
        System.out.println(arrangeCoins.arrangeCoins(8));
        System.out.println(arrangeCoins.arrangeCoins(10));
        System.out.println(arrangeCoins.arrangeCoins(11));
        System.out.println(arrangeCoins.arrangeCoins(16));
    }
}
