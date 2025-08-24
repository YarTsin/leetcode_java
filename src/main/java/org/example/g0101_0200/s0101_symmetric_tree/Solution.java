package org.example.g0101_0200.s0101_symmetric_tree;


/**
 * #Easy #DFS #BFS #Tree #BinaryTree #Recursion
 * Дано бинарное дерево. Необходимо проверить,
 * является ли оно симметричным относительно центра.
 *
 * Требования:
 * Дерево симметрично, если левая и правая половины зеркально отражают друг друга
 * Дерево может содержать до 100 узлов
 * Значения узлов находятся в диапазоне [-100, 100]
 *
 * примеры внизу
 *
 * Оптимальное решение - рекурсия с DFS
 *
 * Самое быстрое решение - 1 ms
 *
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // Пустое дерево симметрично
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // Базовые случаи
        if (left == null && right == null) {
            return true; // Оба узла null - симметрично
        }
        if (left == null || right == null) {
            return false; // Один узел null, другой нет - не симметрично
        }
        if (left.val != right.val) {
            return false; // Значения узлов разные
        }

        // Рекурсивно проверяем зеркальность:
        // Левый ребенок левого узла vs Правый ребенок правого узла
        // Правый ребенок левого узла vs Левый ребенок правого узла
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}

/*
Пример 1
Вход:
    1
   / \
  2   2
 / \ / \
3  4 4  3

Выход: true

Пример 2
Вход:
    1
   / \
  2   2
   \   \
   3    3

Выход: false

Пример 3
Вход:
    1
   / \
  2   2
 /   /
3   3
 */
