package org.example.g0501_0600.s0530_minimum_absolute_difference_in_bst;


import org.example.a_leetcode_classes.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение (с использованием списка)
 */
class Solution2 {
    public int getMinimumDifference(TreeNode root) {
        // Список для хранения значений узлов в порядке in-order обхода
        List<Integer> values = new ArrayList<>();
        // Выполняем in-order обход и заполняем список
        inOrderTraversal(root, values);

        int minDifference = Integer.MAX_VALUE;

        // Проходим по отсортированному списку и находим минимальную разницу
        for (int i = 1; i < values.size(); i++) {
            int difference = values.get(i) - values.get(i - 1);
            minDifference = Math.min(minDifference, difference);
        }

        return minDifference;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        // Обходим левое поддерево
        inOrderTraversal(node.left, values);
        // Добавляем текущее значение
        values.add(node.val);
        // Обходим правое поддерево
        inOrderTraversal(node.right, values);
    }
}
