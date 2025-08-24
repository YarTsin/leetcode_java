package org.example.g0101_0200.s0101_symmetric_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Альтернативное решение (Итеративное с использованием очереди)
 */
class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

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
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
