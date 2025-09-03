package org.example.g0501_0600.s0501_find_mode_in_binary_search_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Решение с использованием HashMap
 *
 * Объяснение:
 * HashMap: Сохраняет частоту каждого значения
 * Обход дерева: Рекурсивный обход для заполнения карты
 * Поиск моды: Находит максимальную частоту и соответствующие значения
 *
 * Недостатки:
 * O(n) дополнительной памяти для HashMap
 * Не использует свойство BST
 */
class Solution3 {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        buildFrequencyMap(root, frequencyMap);

        int maxFrequency = 0;
        List<Integer> modes = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                modes.clear();
                modes.add(entry.getKey());
            } else if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }

        return modes.stream().mapToInt(i -> i).toArray();
    }

    private void buildFrequencyMap(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return;

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        buildFrequencyMap(node.left, map);
        buildFrequencyMap(node.right, map);
    }
}