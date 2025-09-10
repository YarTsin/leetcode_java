package org.example.g0801_0900.s0897_increasing_order_search_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Сбор значений в список + построение нового дерева
 */
class Solution3 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrderCollect(root, values);

        TreeNode dummy = new TreeNode(0);
        TreeNode current = dummy;

        for (int value : values) {
            current.right = new TreeNode(value);
            current = current.right;
        }

        return dummy.right;
    }

    private void inOrderCollect(TreeNode node, List<Integer> values) {
        if (node == null) return;

        inOrderCollect(node.left, values);
        values.add(node.val);
        inOrderCollect(node.right, values);
    }
}
