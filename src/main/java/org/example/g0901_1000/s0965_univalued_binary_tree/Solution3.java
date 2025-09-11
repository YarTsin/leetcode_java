package org.example.g0901_1000.s0965_univalued_binary_tree;

import org.example.a_leetcode_classes.TreeNode;

/**
 * Решение с использованием глобальной переменной
 */
class Solution3 {
    private int targetValue;
    private boolean isUnival = true;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        targetValue = root.val;
        traverse(root);
        return isUnival;
    }

    private void traverse(TreeNode node) {
        if (node == null || !isUnival) {
            return;
        }

        if (node.val != targetValue) {
            isUnival = false;
            return;
        }

        traverse(node.left);
        traverse(node.right);
    }
}
