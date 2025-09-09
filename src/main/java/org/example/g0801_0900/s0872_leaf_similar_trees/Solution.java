package org.example.g0801_0900.s0872_leaf_similar_trees;

// #Easy #Depth_First_Search #Tree #Binary_Tree
// #LeetCode_75_Binary_Tree/DFS #Recursion

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 * Даны корни двух бинарных деревьев root1 и root2.
 * Необходимо определить, являются ли эти деревья
 * "лист-подобными" (leaf-similar).
 *
 * Два дерева считаются leaf-similar, если последовательность
 * листьев (значений листовых узлов) в порядке слева направо
 * одинакова для обоих деревьев.
 *
 * Определение листового узла: Узел, у которого нет дочерних
 * узлов (ни левого, ни правого).
 * (примеры внизу)
 *
 * Решение - обход вглубину - со сбором листьев
 * Это самое быстрое решение - 0 ms
 *
 * Сложность: O(n + m) по времени, O(h1 + h2) по памяти (для рекурсии)
 *
 *
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        // Собираем листья обоих деревьев
        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);

        // Сравниваем последовательности листьев
        return leaves1.equals(leaves2);
    }

    private void collectLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }

        // Если это листовой узел, добавляем его значение
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }

        // Рекурсивно обходим левое и правое поддеревья
        collectLeaves(node.left, leaves);
        collectLeaves(node.right, leaves);
    }
}
/*
Пример 1
Дерево 1:       Дерево 2:
    3               3
   / \             / \
  5   1           5   1
 / \             / \
6   2           6   7
   / \             / \
  7   4           4   2

Листья дерева 1: [6, 7, 4]
Листья дерева 2: [6, 7, 4]  (?)
Выход: true

Пример 2
Дерево 1:       Дерево 2:
    1               1
   / \             / \
  2   3           3   2
Выход: false (разный порядок)


 */