package org.example.g0601_0700.s0637_average_of_levels_in_binary_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение (Обход в глубину с запоминанием сумм и количеств)
 * Сложность:
 * Временная: O(n) - посещаем каждый узел ровно один раз
 * Пространственная: O(h) - где h - высота дерева (для стека вызовов рекурсии)
 */
class Solution2 {
    public List<Double> averageOfLevels(TreeNode root) {
        // Списки для хранения сумм и количеств узлов на каждом уровне
        List<Double> levelSums = new ArrayList<>();
        List<Integer> levelCounts = new ArrayList<>();

        // Рекурсивный обход дерева
        dfs(root, 0, levelSums, levelCounts);

        // Вычисляем средние значения
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < levelSums.size(); i++) {
            result.add(levelSums.get(i) / levelCounts.get(i));
        }

        return result;
    }

    private void dfs(TreeNode node, int level, List<Double> levelSums, List<Integer> levelCounts) {
        if (node == null) {
            return;
        }

        // Если текущий уровень встречается впервые, инициализируем значения
        if (level == levelSums.size()) {
            levelSums.add(0.0);
            levelCounts.add(0);
        }

        // Обновляем сумму и количество для текущего уровня
        levelSums.set(level, levelSums.get(level) + node.val);
        levelCounts.set(level, levelCounts.get(level) + 1);

        // Рекурсивно обходим левое и правое поддеревья
        dfs(node.left, level + 1, levelSums, levelCounts);
        dfs(node.right, level + 1, levelSums, levelCounts);
    }
}
