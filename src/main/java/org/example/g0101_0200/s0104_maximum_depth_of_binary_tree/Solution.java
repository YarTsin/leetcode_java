package org.example.g0101_0200.s0104_maximum_depth_of_binary_tree;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Depth_First_Search #Breadth_First_Search
// #Tree #Binary_Tree #LeetCode_75_Binary_Tree/DFS #Recursion
// #Top_Interview_150_Binary_Tree_General

import org.example.a_leetcode_classes.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * Дано бинарное дерево. Необходимо найти его максимальную глубину.
 * Примеры внизу
 *
 * Оптимальное решение - рекурсивное DFS
 * Самое быстрое решение - 0 ms
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // Базовый случай: пустое дерево имеет глубину 0
        if (root == null) {
            return 0;
        }

        // Рекурсивно находим глубину левого и правого поддеревьев
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Максимальная глубина = 1 (текущий узел) + максимальная из глубин поддеревьев
        return 1 + Math.max(leftDepth, rightDepth);
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

Выход: 3

Пример 2
Вход:
    1
     \
      2

Выход: 2

 */
