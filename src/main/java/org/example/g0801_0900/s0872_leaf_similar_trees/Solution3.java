package org.example.g0801_0900.s0872_leaf_similar_trees;

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Решение с одновременным обходом
 */
class Solution3 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        // Собираем листья одновременно
        collectLeavesSimultaneous(root1, leaves1);
        collectLeavesSimultaneous(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void collectLeavesSimultaneous(TreeNode node, List<Integer> leaves) {
        if (node == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.left == null && current.right == null) {
                leaves.add(current.val);
            }
        }
    }
}
