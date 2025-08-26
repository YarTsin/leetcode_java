package org.example.g0101_0200.s0144_binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * #Easy #DFS #Tree #BinaryTree #Stack #Recursion
 * 144. Binary Tree Preorder Traversal
 *
 * Условие: Дано бинарное дерево. Необходимо вернуть значения узлов
 * в порядке preorder traversal
 * (корень → левое поддерево → правое поддерево).
 * примеры внизу
 *
 * Оптимальное решение (Рекурсивное) - самое быстрое - 0 ms
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }

    private void preorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return; // Базовый случай: достигли конца ветки
        }

        // 1. Посещаем текущий узел (добавляем значение)
        result.add(node.val);

        // 2. Рекурсивно обходим левое поддерево
        preorderRecursive(node.left, result);

        // 3. Рекурсивно обходим правое поддерево
        preorderRecursive(node.right, result);
    }
}
/*
Пример 1
Вход:
    1
     \
      2
     /
    3

Выход: [1, 2, 3]

Пример 2
Вход:
    1
   / \
  2   3
 / \   \
4   5   6

Выход: [1, 2, 4, 5, 3, 6]

 */
