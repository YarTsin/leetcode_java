package org.example.g0201_0300.s0222_count_complete_tree_nodes;

/**
 * Альтернативное решение - Полный обход - не оптимально
 * Объяснение:
 * Простой рекурсивный обход всех узлов
 * Временная сложность: O(n) - не удовлетворяет требованиям
 * Пространственная сложность: O(h)
 */
class Solution3 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
