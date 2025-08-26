package org.example.g0201_0300.s0226_invert_binary_tree;

/**
 * #Easy #Top_100_Liked_Questions #DFS #BFS #Tree #BinaryTree
 * ##LinkedList #Recursion
 * #Top_Interview_150_Binary_Tree_General
 *
 * Инвертировать бинарное дерево (создать его зеркальное отражение).
 * примеры внизу
 *
 * Оптимальное решение - рекурсивное DFS
 *
 * Объяснение подхода:
 * Используем рекурсивный обход в глубину (DFS)
 * Для каждого узла меняем местами его левое и правое поддеревья
 * (полуяается не углубляемся - первые родственники)
 * Временная сложность: O(n) - каждый узел посещается один раз
 * Пространственная сложность: O(h) - высота дерева (для стека вызовов)
 *
 * Самое быстрое решение - 0 ms
 *
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Базовый случай: если узел пустой, возвращаем null
        if (root == null) {
            return null;
        }

        // Рекурсивно инвертируем левое поддерево
        TreeNode invertedLeft = invertTree(root.left);

        // Рекурсивно инвертируем правое поддерево
        TreeNode invertedRight = invertTree(root.right);

        // Меняем местами левое и правое поддеревья
        root.left = invertedRight;
        root.right = invertedLeft;

        // Возвращаем корень инвертированного дерева
        return root;
    }
}

/*
Пример 1
Вход:
     4
   /   \
  2     7
 / \   / \
1   3 6   9

Выход:
     4
   /   \
  7     2
 / \   / \
9   6 3   1

Пример 2
Вход:
     2
   /   \
  1     3

Выход:
     2
   /   \
  3     1

 */


