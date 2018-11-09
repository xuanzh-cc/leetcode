package com.zx.leetcode.common.util;

public class Utils {
    public static void swap(int[] arr, int l, int m) {
        int tmp = arr[l];
        arr[l] = arr[m];
        arr[m] = tmp;
    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
