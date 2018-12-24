package com.zx.leetcode._48;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int middle = len % 2 == 0 ? len / 2 : len / 2 + 1;
        for (int y = 0; y <= middle; y++) {
            for (int x = 0; x <= middle; x++) {
                int vx = x - middle;
                int vy = y - middle;
                int targetVx = vy;
                int targetVy = -vx;
                matrix[middle + targetVy][middle + targetVx] = matrix[y][x];
            }
        }
    }
}
