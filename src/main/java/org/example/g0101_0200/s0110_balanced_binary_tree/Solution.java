package org.example.g0101_0200.s0110_balanced_binary_tree;

// #Easy #Depth_First_Search #Tree #Binary_Tree #Recursion

/**
 *
 * 110. Balanced Binary Tree
 * Условие: Дано бинарное дерево. Необходимо определить,
 * является ли оно сбалансированным по высоте.
 *
 * Определение: Бинарное дерево является сбалансированным
 * по высоте, если для каждой вершины дерева разница высот
 * левого и правого поддеревьев не превышает 1.
 *
 * Требования:
 * Дерево может содержать до 5000 узлов
 * Значения узлов находятся в диапазоне [-10^4, 10^4]
 *
 * примеры внизу
 *
 * Оптимальное решение (Рекурсивное с проверкой баланса)
 *
 * Самое быстрое решение: 0 ms
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode node) {
        // Базовый случай: пустое дерево имеет высоту 0
        if (node == null) {
            return 0;
        }

        // Рекурсивно проверяем левое поддерево
        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) {
            return -1; // Левое поддерево несбалансировано
        }

        // Рекурсивно проверяем правое поддерево
        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) {
            return -1; // Правое поддерево несбалансировано
        }

        // Проверяем баланс текущего узла
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Текущий узел несбалансирован
        }

        // Возвращаем высоту текущего поддерева
        return 1 + Math.max(leftHeight, rightHeight);
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
Выход: true

Пример 2:
Вход:
        1
       / \
      2   2
     / \
    3   3
   / \
  4   4

Выход: false
 */
