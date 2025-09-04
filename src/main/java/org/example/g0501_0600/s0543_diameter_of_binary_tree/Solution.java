package org.example.g0501_0600.s0543_diameter_of_binary_tree;

// #Easy #Top_100_Liked_Questions #Depth_First_Search #Tree #Binary_Tree


import org.example.a_leetcode_classes.TreeNode;

/**
 * 543. Diameter of Binary Tree
 *
 * Дан корень бинарного дерева. Необходимо найти длину диаметра дерева.
 * Диаметр бинарного дерева - это длина самого длинного пути между любыми
 * двумя узлами в дереве. Этот путь может проходить через корень,
 * а может и не проходить.
 *
 * Важные уточнения:
 * Длина пути измеряется количеством ребер между узлами
 * Диаметр может проходить через корень, а может быть полностью в левом или правом поддереве
 * Дерево может быть несбалансированным
 * Количество узлов в дереве от 1 до 10^4
 * (примеры внизу)
 *
 * Решение - рекурсивный обход - это самое быстрое решение - 0 ms
 */
class Solution {
    // Переменная для хранения максимального диаметра
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // Запускаем рекурсивный обход дерева
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Рекурсивно вычисляем высоту левого и правого поддеревьев
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Обновляем максимальный диаметр
        // Диаметр через текущий узел = leftHeight + rightHeight
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Возвращаем высоту текущего поддерева
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
/*
Пример 1
Вход: root = [1,2,3,4,5]
        1
       / \
      2   3
     / \
    4   5
Ответ: 3
Объяснение: Диаметр - путь [4,2,1,3] или [4,2,1,3] длиной 3 ребра (4-2-1-3)

Пример 2
Вход: root = [1,2]
    1
   /
  2

Объяснение подхода:
Рекурсивный расчет высоты: Для каждого узла вычисляем высоту левого и правого поддеревьев
Обновление диаметра: Диаметр через текущий узел равен сумме высот левого и правого поддеревьев
Глобальное отслеживание: Сохраняем максимальный найденный диаметр

 */
