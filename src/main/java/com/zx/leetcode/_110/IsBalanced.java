package com.zx.leetcode._110;

import com.zx.leetcode.common.TreeNode;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int heightLeft = depth(left);
        int heightRight = depth(right);
        if (Math.abs(heightLeft - heightRight) <= 1) {
            return isBalanced(left) && isBalanced(right);
        } else {
            return false;
        }
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int depth = 1;
            TreeNode left = node.left;
            TreeNode right = node.right;
            int depthLeft = depth(left);
            int depthRight = depth(right);
            return depthLeft > depthRight ? depth + depthLeft : depth + depthRight;
        }
    }
}
