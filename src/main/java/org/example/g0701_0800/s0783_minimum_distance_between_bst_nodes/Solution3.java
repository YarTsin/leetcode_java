package org.example.g0701_0800.s0783_minimum_distance_between_bst_nodes;

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с сбором всех значений
 * Менее эффективное решение, но проще для понимания
 * Сложность: O(n) по времени, O(n) по памяти.
 * Плюсы: Очень простое для понимания.
 * Минусы: Требует O(n) дополнительной памяти для хранения всех значений.
 */
class Solution3 {
    public int minDiffInBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        // Собираем все значения в список
        collectValues(root, values);

        // Сортируем значения (для BST in-order уже отсортирован, но на всякий случай)
        // values.sort(Integer::compareTo);

        int minDiff = Integer.MAX_VALUE;
        // Находим минимальную разницу между последовательными значениями
        for (int i = 1; i < values.size(); i++) {
            int diff = values.get(i) - values.get(i - 1);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    private void collectValues(TreeNode node, List<Integer> values) {
        if (node == null) return;
        collectValues(node.left, values);
        values.add(node.val);
        collectValues(node.right, values);
    }
}
