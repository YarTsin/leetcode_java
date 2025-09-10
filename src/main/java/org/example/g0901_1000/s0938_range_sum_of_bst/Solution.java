package org.example.g0901_1000.s0938_range_sum_of_bst;

// #Easy #Depth_First_Search #Tree
// #Binary_Tree #Binary_Search_Tree #Recursion

import org.example.a_leetcode_classes.TreeNode;

/**
 * 938. Range Sum of BST
 *
 * Дано бинарное дерево поиска (BST) и два целых числа low и high.
 * Необходимо вернуть сумму всех значений узлов в дереве, которые
 * находятся в диапазоне [low, high] включительно.
 *
 * Особенности BST:
 * Левый подузел содержит значения меньше значения родительского узла
 * Правый подузел содержит значения больше значения родительского узла
 * Каждое поддерево также является BST
 *
 * Пример 1
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Объяснение: Узлы 7, 10, 15 находятся в
 * диапазоне [7,15] → 7 + 10 + 15 = 32
 *
 * Пример 2
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Объяснение: Узлы 6, 7, 10 находятся в диапазоне [6,10] → 6 + 7 + 10 = 23
 *
 * Решение: Используем обход в глубину (DFS) с обрезкой (pruning).
 * Самое быстрое решение - 0 ms
 *
 * Воспользуемся свойствами BST:
 * Если значение узла меньше low, можно пропустить все левое поддерево
 * Если значение узла больше high, можно пропустить все правое поддерево
 * Только если значение в диапазоне, обходим оба поддерева
 *
 * Сложность:
 * Время: O(n) в худшем случае, но O(log n) в среднем с pruning
 * Память: O(h) где h - высота дерева (для стека вызовов)
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int currentSum = 0;

        // Если значение узла в диапазоне, добавляем его к сумме
        if (root.val >= low && root.val <= high) {
            currentSum += root.val;
        }

        // Если значение больше low, обходим левое поддерево
        // (в левом поддереве могут быть значения >= low)
        if (root.val > low) {
            currentSum += rangeSumBST(root.left, low, high);
        }

        // Если значение меньше high, обходим правое поддерево
        // (в правом поддереве могут быть значения <= high)
        if (root.val < high) {
            currentSum += rangeSumBST(root.right, low, high);
        }

        return currentSum;
    }
}