package org.example.g0601_0700.s0671_second_minimum_node_in_a_binary_tree;

// #Easy #Depth_First_Search #Tree #Binary_Tree #Recursion


import org.example.a_leetcode_classes.TreeNode;

/**
 * 671. Second Minimum Node In a Binary Tree
 *
 * Дано непустое специальное бинарное дерево, состоящее из узлов
 * с неотрицательными значениями. Каждый узел в этом дереве имеет либо
 * ноль, либо два дочерних узла. Особенность дерева в том, что значение
 * каждого узла равно минимальному значению из его двух дочерних узлов.
 *
 * Свойства дерева:
 * Каждый узел имеет 0 или 2 детей
 * Если у узла есть дети, то node.val = min(node.left.val, node.right.val)
 * Корневой узел имеет минимальное значение во всем дереве
 *
 * todo запутанное условие
 *
 * Необходимо найти второе минимальное значение в дереве.
 * Если второго минимального значения не существует, вернуть -1.
 *
 * Пример 1
 * Вход: root = [2,2,5,null,null,5,7]
 * Выход: 5
 * Объяснение:
 * Наименьшее значение = 2, второе наименьшее = 5.
 *
 * Пример 2
 * Вход: root = [2,2,2]
 * Выход: -1
 * Объяснение:
 * Все значения равны 2, поэтому второго минимального нет.
 *
 * Пример 3
 * Вход: root = [1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
 * Выход: 2
 *
 * Решение - рекурсивный обход - это самое быстрое решение - 0 ms
 *
 * Сложность:
 * Временная: O(n) - обход всех узлов
 * Пространственная: O(h) - высота дерева для стека рекурсии
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        // Используем long для обработки крайних случаев
        long[] result = new long[]{Long.MAX_VALUE, Long.MAX_VALUE};
        dfs(root, result);

        // Если второго минимального не найдено, возвращаем -1
        return result[1] == Long.MAX_VALUE ? -1 : (int) result[1];
    }

    private void dfs(TreeNode node, long[] minValues) {
        if (node == null) {
            return;
        }

        // Обновляем два минимальных значения
        if (node.val < minValues[0]) {
            minValues[1] = minValues[0];
            minValues[0] = node.val;
        } else if (node.val > minValues[0] && node.val < minValues[1]) {
            minValues[1] = node.val;
        }

        // Рекурсивно обходим детей
        dfs(node.left, minValues);
        dfs(node.right, minValues);
    }
}
