package org.example.g0101_0200.s0111_minimum_depth_of_binary_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.Stack;

/**
 * Альтернативное решение (DFS со стеком
 */
class Solution3 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int minDepth = Integer.MAX_VALUE;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        nodeStack.push(root);
        depthStack.push(1);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int currentDepth = depthStack.pop();

            // Если это лист, обновляем минимальную глубину
            if (currentNode.left == null && currentNode.right == null) {
                minDepth = Math.min(minDepth, currentDepth);
            }

            // Добавляем правого ребенка
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                depthStack.push(currentDepth + 1);
            }

            // Добавляем левого ребенка
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                depthStack.push(currentDepth + 1);
            }
        }

        return minDepth;
    }
}
