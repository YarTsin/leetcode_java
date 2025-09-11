package org.example.g0901_1000.s0965_univalued_binary_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Решение с подсчетом уникальных значений
 * Подход: Используем HashSet для отслеживания уникальных значений.
 *
 * Недостатки:
 * Использует дополнительную память O(n) для HashSet
 * Менее эффективно, так как продолжает обход даже после
 * обнаружения разных значений
 */
class Solution4 {
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> values = new HashSet<>();
        collectValues(root, values);
        return values.size() == 1;
    }

    private void collectValues(TreeNode node, Set<Integer> values) {
        if (node == null) {
            return;
        }

        values.add(node.val);

        // Если уже нашли более одного значения, можно прерваться
        if (values.size() > 1) {
            return;
        }

        collectValues(node.left, values);
        collectValues(node.right, values);
    }
}
