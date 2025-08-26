package org.example.g0101_0200.s0111_minimum_depth_of_binary_tree;

/**
 * #Easy #DFS #BFS #Tree #BinaryTree
 *
 * Дано бинарное дерево. Необходимо найти его минимальную глубину.
 *
 * Требования:
 * Дерево может содержать до 10^5 узлов
 * Значения узлов находятся в диапазоне [-1000, 1000]
 * примеры внизу
 *
 * Оптимальное решение - рекурсивное DFS
 *
 * 6 по скорости решение - 5 ms
 */
class Solution {
    public int minDepth(TreeNode root) {
        // Базовый случай: пустое дерево имеет глубину 0
        if (root == null) {
            return 0;
        }

        // Если нет левого ребенка, идем только вправо
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // Если нет правого ребенка, идем только влево
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // Если есть оба ребенка, берем минимальную глубину
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
/*
Пример 1
Вход:
    3
   / \
  9  20
    /  \
   15   7

Выход: 2

Пример 2
Вход:
        2
         \
          3
           \
            4
             \
              5
               \
                6

Выход: 5








 */
