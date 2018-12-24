package com.zx.leetcode._107;

import com.zx.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> layer = new ArrayList<>();
        layer.add(root);
        while (layer.size() > 0) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            List<TreeNode> nextLayer = new ArrayList<>();
            for (TreeNode node : layer ) {
                list.add(node.val);
                if (node.left != null) {
                    nextLayer.add(node.left);
                }

                if (node.right != null) {
                    nextLayer.add(node.right);
                }

                layer = nextLayer;
            }
        }
        Collections.reverse(result);
        return result;
    }
}
