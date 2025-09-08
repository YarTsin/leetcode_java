package org.example.g0701_0800.s0783_minimum_distance_between_bst_nodes;

import org.example.a_leetcode_classes.TreeNode;

import java.util.Stack;

/**
 * Итеративный in-order обход
 * Плюсы: Избегает переполнения стека вызовов
 * для очень больших деревьев.
 * Минусы: Код slightly более сложный для понимания.
 */
class Solution2 {
    public int minDiffInBST(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Добираемся до самого левого узла
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Обрабатываем узел
            current = stack.pop();
            if (prev != null) {
                minDiff = Math.min(minDiff, current.val - prev);
            }
            prev = current.val;

            // Переходим к правому поддереву
            current = current.right;
        }

        return minDiff;
    }
}
