package org.example.g0601_0700.s0617_merge_two_binary_trees;

import org.example.a_leetcode_classes.TreeNode;

import java.util.Stack;

/**
 * Альтернативное решение (Итеративное с использованием стека)
 * Сложность:
 * Временная: O(n) - обход всех узлов
 * Пространственная: O(h) - высота стека
 */
class Solution2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Обработка случая, когда одно из деревьев пустое
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // Стек для хранения пар узлов для обработки
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{root1, root2});

        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];

            // Если второй узел null, пропускаем
            if (node2 == null) {
                continue;
            }

            // Суммируем значения узлов
            node1.val += node2.val;

            // Обработка левых потомков
            if (node1.left == null) {
                node1.left = node2.left;
            } else {
                stack.push(new TreeNode[]{node1.left, node2.left});
            }

            // Обработка правых потомков
            if (node1.right == null) {
                node1.right = node2.right;
            } else {
                stack.push(new TreeNode[]{node1.right, node2.right});
            }
        }

        return root1;
    }
}
