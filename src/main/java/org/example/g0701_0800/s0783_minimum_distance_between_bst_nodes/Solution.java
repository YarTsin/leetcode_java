package org.example.g0701_0800.s0783_minimum_distance_between_bst_nodes;

// #Easy #Depth_First_Search #Breadth_First_Search
// #Tree #Binary_Tree #Binary_Search_Tree #Recursion
// #Morris

import org.example.a_leetcode_classes.TreeNode;

/**
 * 783. Minimum Distance Between BST Nodes
 * Условие: Дан корень бинарного дерева поиска (BST - Binary Search Tree).
 * Нужно найти минимальную разницу между значениями любых двух различных
 * узлов в дереве.
 *
 * Важные детали:
 * BST свойства: Для любого узла:
 * Все значения в левом поддереве меньше значения узла
 * Все значения в правом поддереве больше значения узла
 * Минимальная разница: Поскольку дерево является BST,
 * минимальная разница всегда будет между двумя последовательными
 * значениями при обходе дерева в порядке возрастания (in-order traversal).
 * В дереве как минимум 2 узла.
 * (примеры внизу)
 *
 * Решение - In-order обход с отслеживанием предыдущего значения
 * c рекурсией - самое быстрое решение - 0 ms
 */
class Solution {
    // Переменная для хранения предыдущего значения при in-order обходе
    private Integer prev = null;
    // Переменная для хранения минимальной разницы
    private int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        // Выполняем in-order обход дерева
        inOrderTraversal(root);
        return minDiff;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // Рекурсивно обходим левое поддерево
        inOrderTraversal(node.left);

        // Обрабатываем текущий узел
        if (prev != null) {
            // Вычисляем разницу между текущим и предыдущим значением
            int diff = node.val - prev;
            // Обновляем минимальную разницу
            minDiff = Math.min(minDiff, diff);
        }
        // Обновляем предыдущее значение
        prev = node.val;

        // Рекурсивно обходим правое поддерево
        inOrderTraversal(node.right);
    }
}
/*
Пример 1
Ввод: root = [4,2,6,1,3]
      4
     / \
    2   6
   / \
  1   3

Вывод: 1
Объяснение:
Значения узлов: [1, 2, 3, 4, 6]
Разницы между последовательными значениями:
2-1 = 1, 3-2 = 1, 4-3 = 1, 6-4 = 2
Минимальная разница = 1

Пример 2
Ввод: root = [1,0,48,null,null,12,49]
      1
     / \
    0   48
        / \
       12  49

Вывод: 1
Объяснение:
Значения узлов: [0, 1, 12, 48, 49]
Разницы: 1-0=1, 12-1=11, 48-12=36, 49-48=1
Минимальная разница = 1
 */