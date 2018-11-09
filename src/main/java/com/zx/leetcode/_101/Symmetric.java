package com.zx.leetcode._101;

public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        return isSubSymmetric(left, right);
    }

    private boolean isSubSymmetric(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            } else {
                TreeNode lLeft = left.left;
                TreeNode lRight = left.right;

                TreeNode rLeft = right.left;
                TreeNode rRight = right.right;

                return isSubSymmetric(lLeft, rRight) && isSubSymmetric(lRight, rLeft);
            }
        } else if (left == null && right == null) {
            return true;
        } else {
            return false;
        }
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
