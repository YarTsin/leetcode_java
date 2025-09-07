package org.example.g0601_0700.s0617_merge_two_binary_trees;

// #Easy #Depth_First_Search #Breadth_First_Search #Tree #Binary_Tree

import org.example.a_leetcode_classes.TreeNode;

/**
 * 617. Merge Two Binary Trees
 *
 * Даны два бинарных дерева root1 и root2.
 * Необходимо объединить их в новое бинарное дерево по следующим правилам:
 * - Если соответствующие узлы обоих деревьев существуют,
 * их значения суммируются
 * - Если один из узлов существует, а другого нет,
 * используется существующий узел
 * Если оба узла отсутствуют, соответствующий узел
 * в новом дереве будет null
 *  Новое дерево должно быть построено путем слияния исходных деревьев (нельзя просто создавать новое дерево без использования существующих узлов).
 *  (примеры внизу)
 *
 * Решение через рекурсию - самое быстрое 0 ms
 *
 * Временная: O(n) - где n - количество узлов в меньшем дереве
 * Пространственная: O(h) - где h - высота дерева (для стека вызовов)
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Базовый случай: если оба узла null, возвращаем null
        if (root1 == null && root2 == null) {
            return null;
        }

        // Если один из узлов null, возвращаем существующий узел
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // Создаем новый узел с суммой значений
        TreeNode mergedNode = new TreeNode(root1.val + root2.val);

        // Рекурсивно объединяем левые и правые поддеревья
        mergedNode.left = mergeTrees(root1.left, root2.left);
        mergedNode.right = mergeTrees(root1.right, root2.right);

        return mergedNode;
    }
}
/*
Пример 1
Вход:
Дерево 1:      1           Дерево 2:    2           Результат:   3
              / \                      / \                      / \
             3   2                    1   3                    4   5
            /                          \   \                  / \   \
           5                            4   7                5   4   7

Объяснение:
- Корень: 1 + 2 = 3
- Левое поддерево: 3 + 1 = 4
- Правое поддерево: 2 + 3 = 5
- Узел 5: 5 + null = 5
- Узел 4: null + 4 = 4
- Узел 7: null + 7 = 7


Пример 2
Вход:
Дерево 1:   1    Дерево 2: 1     Результат:   2
           /                \                /
          2                  2              2

 */
