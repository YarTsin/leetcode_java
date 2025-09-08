package org.example.g0701_0800.s0783_minimum_distance_between_bst_nodes;

import org.example.a_leetcode_classes.TreeNode;

/**
 * Решение с использованием Morris In-order Traversal
 * Наиболее оптимальное по памяти решение (O(1) дополнительной памяти):
 * Минусы: Сложный для понимания алгоритм, модифицирует дерево на время обхода.
 */
class Solution4 {
    public int minDiffInBST(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // Обрабатываем текущий узел
                if (prev != null) {
                    minDiff = Math.min(minDiff, current.val - prev);
                }
                prev = current.val;
                current = current.right;
            } else {
                // Находим предшественника
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Создаем временную связь
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Удаляем временную связь и обрабатываем узел
                    predecessor.right = null;
                    if (prev != null) {
                        minDiff = Math.min(minDiff, current.val - prev);
                    }
                    prev = current.val;
                    current = current.right;
                }
            }
        }

        return minDiff;
    }
}
