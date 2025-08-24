package org.example.g0101_0200.s0101_symmetric_tree;

import java.util.Stack;

/**
 * Альтернативное решение (Итеративное с использованием стека)
 */
class Solution3 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            // Оба узла null - продолжаем проверку
            if (left == null && right == null) {
                continue;
            }

            // Один узел null, другой нет - не симметрично
            if (left == null || right == null) {
                return false;
            }

            // Значения узлов разные - не симметрично
            if (left.val != right.val) {
                return false;
            }

            // Добавляем детей в зеркальном порядке
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }
}
