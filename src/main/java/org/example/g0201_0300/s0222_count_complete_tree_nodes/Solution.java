package org.example.g0201_0300.s0222_count_complete_tree_nodes;

/**
 * #Easy #DFS #Tree #BinarySearch #BinaryTree #Recursion
 * #Top_Interview_150_Binary_Tree_General
 *
 * 222. Count Complete Tree Nodes
 *
 * Задача: Подсчитать количество узлов в полном бинарном дереве.
 *
 * Полное бинарное дерево - это бинарное дерево, в котором:
 * Все уровни полностью заполнены, кроме, возможно, последнего
 * Последний уровень заполнен слева направо
 *
 * Важные уточнения:
 * Дерево гарантированно является полным
 * Нужно решить задачу за время меньшее чем O(n)
 * Нельзя просто обойти все узлы (это было бы O(n))
 *
 * Формат ввода: Корень полного бинарного дерева
 * Формат вывода: Целое число - количество узлов в дереве
 * примеры внизу
 *
 * Оптимальное решение (Бинарный поиск по последнему уровню)
 *
 * Объяснение подхода:
 * Вычисляем высоту по левому и правому краям
 * Если высоты равны - дерево идеальное, используем формулу 2^h - 1
 * Если нет - рекурсивно считаем узлы в поддеревьях
 * Временная сложность: O(log² n) - на каждом уровне рекурсии делаем O(log n) операций
 * Пространственная сложность: O(log n)
 *
 * Это самое быстрое решение - 0 ms
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // Если дерево идеально сбалансировано
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1; // 2^h - 1
        }

        // Рекурсивно считаем узлы в левом и правом поддеревьях
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
/*
Пример 1
Вход:
      1
     / \
    2   3
   / \  /
  4  5 6

Выход: 6

Пример 2
Вход:
      1
     / \
    2   3
   / \
  4  5

Выход: 5

Пример 3
Вход: []
Выход: 0

 */