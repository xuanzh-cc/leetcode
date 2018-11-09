package com.zx.leetcode._129;

import com.zx.leetcode.common.TreeNode;

public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return calLeafSum(0, root);
    }

    private int calLeafSum(int preVal, TreeNode node) {
        int sum = 0;
        int incr = preVal * 10 + node.val;
        if (isLeaf(node)) {
            return sum + incr;
        } else {
            if (node.left != null) {
                sum = sum + calLeafSum(incr, node.left);
            }
            if (node.right != null) {
                sum = sum + calLeafSum(incr, node.right);
            }
        }

        return sum;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
