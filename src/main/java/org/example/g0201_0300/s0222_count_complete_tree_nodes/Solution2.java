package org.example.g0201_0300.s0222_count_complete_tree_nodes;

import org.example.a_leetcode_classes.TreeNode;

/**
 * Альтернативное решение - бинарный поиск по последнему уровню
 * Объяснение:
 * Используем бинарный поиск чтобы найти последний существующий
 * узел на последнем уровне
 * Сложность: O(log² n)
 */
class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = getDepth(root);
        if (depth == 0) {
            return 1;
        }

        // Бинарный поиск по последнему уровню
        int left = 0;
        int right = (1 << depth) - 1; // Максимальное количество узлов на последнем уровне

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (existsNode(root, depth, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Общее количество узлов = узлы всех уровней кроме последнего + узлы последнего уровня
        return (1 << depth) - 1 + left; // (2^d - 1) + количество узлов на последнем уровне
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node.left != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    private boolean existsNode(TreeNode node, int depth, int index) {
        int left = 0;
        int right = (1 << depth) - 1;

        for (int i = 0; i < depth; i++) {
            int mid = left + (right - left) / 2;
            if (index <= mid) {
                node = node.left;
                right = mid;
            } else {
                node = node.right;
                left = mid + 1;
            }
        }

        return node != null;
    }
}
