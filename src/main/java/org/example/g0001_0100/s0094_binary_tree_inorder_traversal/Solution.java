package org.example.g0001_0100.s0094_binary_tree_inorder_traversal;
// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Depth_First_Search #Tree #Binary_Tree
// #Stack #Udemy_Tree_Stack_Queue #Recursion

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 94. Binary Tree Inorder Traversal
 *
 * Условие: Дано бинарное дерево. Необходимо вернуть значения узлов в
 * порядке inorder traversal (левое поддерево → корень → правое поддерево).
 *
 * Требования:
 * Вернуть список значений в порядке inorder обхода
 * Дерево может содержать до 100 узлов
 * Значения узлов находятся в диапазоне [-100, 100]
 *
 * (Примеры внизу)
 * Оптимальное решение - рекурсивное
 *
 * todo доделать
 *
 * самое быстрое - 0 ms
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    private void inorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return; // Базовый случай: достигли конца ветки
        }

        // 1. Рекурсивно обходим левое поддерево
        inorderRecursive(node.left, result);

        // 2. Посещаем текущий узел (добавляем значение)
        result.add(node.val);

        // 3. Рекурсивно обходим правое поддерево
        inorderRecursive(node.right, result);
    }
}
/*
Пример 1 (непонятно)
Вход:
    1
     \
      2
     /
    3

Выход: [1, 3, 2]

Пример 2
Вход:
    1
   / \
  2   3
 / \   \
4   5   6

Выход: [4, 2, 5, 1, 3, 6]

 */