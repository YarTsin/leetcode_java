package org.example.g0901_1000.s0938_range_sum_of_bst;

import org.example.a_leetcode_classes.TreeNode;

import java.util.Stack;

/**
 * Iterative DFS решение
 * Используем стек для итеративного обхода в глубину.
 */
class Solution4 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }

            // Добавляем правого потомка, если есть вероятность найти значения в диапазоне
            if (node.right != null && node.val < high) {
                stack.push(node.right);
            }

            // Добавляем левого потомка, если есть вероятность найти значения в диапазоне
            if (node.left != null && node.val > low) {
                stack.push(node.left);
            }
        }

        return sum;
    }
}
