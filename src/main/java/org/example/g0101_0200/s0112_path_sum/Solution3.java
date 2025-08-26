package org.example.g0101_0200.s0112_path_sum;

import java.util.Stack;

/**
 * Альтернативное решение (DFS со стеком)
 */
class Solution3 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        nodeStack.push(root);
        sumStack.push(root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int currentSum = sumStack.pop();

            // Если это лист и сумма совпадает
            if (currentNode.left == null && currentNode.right == null && currentSum == targetSum) {
                return true;
            }

            // Добавляем правого ребенка
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                sumStack.push(currentSum + currentNode.right.val);
            }

            // Добавляем левого ребенка
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                sumStack.push(currentSum + currentNode.left.val);
            }
        }

        return false;
    }
}
