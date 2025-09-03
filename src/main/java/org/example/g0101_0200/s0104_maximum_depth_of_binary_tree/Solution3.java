package org.example.g0101_0200.s0104_maximum_depth_of_binary_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.Stack;

/**
 * Альтернативное решение (Итеративное DFS со стеком)
 */
class Solution3 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        nodeStack.push(root);
        depthStack.push(1);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int currentDepth = depthStack.pop();

            // Обновляем максимальную глубину
            maxDepth = Math.max(maxDepth, currentDepth);

            // Добавляем правого ребенка (будет обработан первым)
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

        return maxDepth;
    }
}
