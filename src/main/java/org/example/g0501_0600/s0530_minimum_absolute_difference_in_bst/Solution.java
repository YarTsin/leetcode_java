package org.example.g0501_0600.s0530_minimum_absolute_difference_in_bst;

// #Easy #Depth_First_Search #Breadth_First_Search #Tree #Binary_Tree #Binary_Search_Tree
// #Top_Interview_150_Binary_Search_Tree

import org.example.a_leetcode_classes.TreeNode;


/**
 * 530. Minimum Absolute Difference in BST
 *
 * Дан корень бинарного дерева поиска (BST - Binary Search Tree).
 * Необходимо найти минимальную абсолютную разницу между значениями
 * любых двух различных узлов в дереве.
 *
 * Важные уточнения:
 * Бинарное дерево поиска имеет свойство: для каждого узла все значения
 * в левом поддереве меньше значения узла, а все значения в правом поддереве
 * больше значения узла
 * Минимальная абсолютная разница вычисляется как минимальная разница по
 * модулю между значениями любой пары различных узлов
 * В дереве есть 2 узла (гарантируется условиями задачи)
 * (примеры внизу)
 *
 * Решение: In-order обход - самое быстрое решение - 0 ms
 *
 * Объяснение подхода:
 * In-order обход: В BST in-order обход посещает узлы в возрастающем порядке
 * Сравнение соседних значений: Поскольку узлы посещаются в отсортированном порядке,
 * минимальная разница обязательно будет между соседними узлами в этом порядке
 * Эффективность: Время O(n), память O(h) где h - высота дерева
 */
class Solution {
    // Переменная для хранения предыдущего значения при in-order обходе
    private Integer previousValue = null;
    // Переменная для хранения минимальной разницы
    private int minDifference = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        // Выполняем in-order обход дерева
        inOrderTraversal(root);
        return minDifference;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // Рекурсивно обходим левое поддерево
        inOrderTraversal(node.left);

        // Обрабатываем текущий узел
        if (previousValue != null) {
            // Вычисляем разницу между текущим и предыдущим значением
            int currentDifference = Math.abs(node.val - previousValue);
            // Обновляем минимальную разницу если нужно
            minDifference = Math.min(minDifference, currentDifference);
        }

        // Обновляем предыдущее значение
        previousValue = node.val;

        // Рекурсивно обходим правое поддерево
        inOrderTraversal(node.right);
    }
}
/*
Пример 1
Вход: root = [4,2,6,1,3]
    4
   / \
  2   6
 / \
1   3
Ответ: 1
Объяснение: Минимальная разница между значениями
узлов: |1-2| = 1, |2-3| = 1, |3-4| = 1, |4-6| = 2

Пример 2
Вход: root = [1,0,48,null,null,12,49]
    1
   / \
  0   48
      / \
     12  49
Ответ: 1
Объяснение: Минимальная разница |0-1| = 1

 */