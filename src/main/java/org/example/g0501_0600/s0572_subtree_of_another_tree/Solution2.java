package org.example.g0501_0600.s0572_subtree_of_another_tree;


import org.example.a_leetcode_classes.TreeNode;

/**
 * Решение с сериализацией
 * Подход:
 * Сериализуем деревья в строки и проверяем, содержится ли
 * сериализация subRoot в сериализации root.
 *
 * Преимущества:
 * Время выполнения: O(m + n) для сериализации + O(m*n) для поиска подстроки
 * Более эффективно на практике для больших деревьев
 *
 * Недостатки:
 * Может быть ложное срабатывание из-за совпадения значений
 * Требует осторожного выбора разделителей
 */
class Solution2 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Сериализуем оба дерева
        String rootSerialized = serializeTree(root);
        String subRootSerialized = serializeTree(subRoot);

        // Проверяем, содержится ли сериализация subRoot в сериализации root
        return rootSerialized.contains(subRootSerialized);
    }

    /**
     * Сериализует дерево в строку с использованием префиксного обхода
     * Добавляет специальные символы для различения структур
     */
    private String serializeTree(TreeNode node) {
        if (node == null) {
            return "#"; // Представляем null узлы
        }

        // Используем префиксный обход и добавляем разделители
        return "^" + node.val + serializeTree(node.left) + serializeTree(node.right);
    }
}
