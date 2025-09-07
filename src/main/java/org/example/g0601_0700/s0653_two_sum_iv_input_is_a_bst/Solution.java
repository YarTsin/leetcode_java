package org.example.g0601_0700.s0653_two_sum_iv_input_is_a_bst;

// #Easy #Hash_Table #Depth_First_Search #Breadth_First_Search
// #Tree #Binary_Tree #Two_Pointers
// #Binary_Search_Tree

import org.example.a_leetcode_classes.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. Two Sum IV - Input is a BST
 *
 * Дан корень бинарного дерева поиска (BST) и целевое число k.
 * Необходимо определить, существуют ли в дереве два различных узла,
 * такие что сумма их значений равна k.
 *
 * Условия:
 * Количество узлов в дереве: от 1 до 10^4
 * Значения узлов: от -10^4 до 10^4
 * Целевое число k: от -10^5 до 10^5
 *
 * Пример 1
 * Вход: root = [5,3,6,2,4,null,7], k = 9
 * Выход: true
 * Объяснение: Узлы со значениями 5 и 4 (или 3 и 6) дают в сумме 9
 *
 * Пример 2
 * Вход: root = [2,1,3], k = 4
 * Выход: true
 *
 * Решение - обход в глубину с HashSet - 4 решение - 4 ms
 *
 * Сложность:
 *
 * Временная: O(n) - посещаем каждый узел ровно один раз
 * Пространственная: O(n) - для хранения HashSet и стека рекурсии
 *
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // Используем HashSet для хранения встреченных значений
        Set<Integer> seenValues = new HashSet<>();

        // Обходим дерево в глубину (DFS)
        return dfs(root, k, seenValues);
    }

    private boolean dfs(TreeNode node, int k, Set<Integer> seenValues) {
        if (node == null) {
            return false;
        }

        // Проверяем, есть ли в множестве число, которое в сумме с текущим дает k
        int complement = k - node.val;
        if (seenValues.contains(complement)) {
            return true;
        }

        // Добавляем текущее значение в множество
        seenValues.add(node.val);

        // Рекурсивно проверяем левое и правое поддеревья
        return dfs(node.left, k, seenValues) || dfs(node.right, k, seenValues);
    }
}