package org.example.g0401_0500.s0404_sum_of_left_leaves;


import org.example.a_leetcode_classes.TreeNode;

import java.util.Stack;

/**
 * Альтернативное решение 1 (Итеративное с использованием стека)
 *
 */
class Solution2 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int totalSum = 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Boolean> isLeftStack = new Stack<>();

        nodeStack.push(root);
        isLeftStack.push(false); // Корень не является левым потомком

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            boolean isLeftChild = isLeftStack.pop();

            // Если это лист и левый потомок, добавляем к сумме
            if (currentNode.left == null && currentNode.right == null && isLeftChild) {
                totalSum += currentNode.val;
            }

            // Добавляем правого потомка в стек
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                isLeftStack.push(false); // Правый потомок
            }

            // Добавляем левого потомка в стек
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                isLeftStack.push(true); // Левый потомок
            }
        }

        return totalSum;
    }
}