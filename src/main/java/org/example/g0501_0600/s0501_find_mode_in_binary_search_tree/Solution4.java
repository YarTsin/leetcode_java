package org.example.g0501_0600.s0501_find_mode_in_binary_search_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с использованием DFS и списка
 *
 * Объяснение:
 * Сбор значений: In-order обход собирает значения в отсортированном порядке
 * Поиск в списке: Линейный проход по отсортированному списку
 * Простота: Легко понять и реализовать
 *
 * Недостатки:
 * O(n) дополнительной памяти для хранения значений
 * Два прохода: по дереву и по списку
 *
 */
class Solution4 {
    private List<Integer> values = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        // Собираем все значения в список
        inOrderCollect(root);

        // Находим моду в отсортированном списке
        List<Integer> modes = new ArrayList<>();
        int currentCount = 1;
        int maxCount = 1;

        modes.add(values.get(0));

        for (int i = 1; i < values.size(); i++) {
            if (values.get(i).equals(values.get(i - 1))) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                modes.clear();
                modes.add(values.get(i));
            } else if (currentCount == maxCount) {
                modes.add(values.get(i));
            }
        }

        return modes.stream().mapToInt(i -> i).toArray();
    }

    private void inOrderCollect(TreeNode node) {
        if (node == null) return;
        inOrderCollect(node.left);
        values.add(node.val);
        inOrderCollect(node.right);
    }
}