package org.example.g0801_0900.s0872_leaf_similar_trees;

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Решение с итеративным обходом
 */
class Solution2 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = getLeavesIterative(root1);
        List<Integer> leaves2 = getLeavesIterative(root2);

        return leaves1.equals(leaves2);
    }

    private List<Integer> getLeavesIterative(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        if (root == null) return leaves;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.left == null && node.right == null) {
                leaves.add(node.val);
            }
        }

        return leaves;
    }
}
