package org.example.g0801_0900.s0897_increasing_order_search_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.Stack;

/**
 * Итеративный in-order обход с использованием стека
 */
class Solution2 {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        TreeNode current = dummy;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            // Добираемся до самого левого узла
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // Извлекаем узел из стека
            node = stack.pop();

            // Обрабатываем узел
            node.left = null;
            current.right = node;
            current = node;

            // Переходим к правому поддереву
            node = node.right;
        }

        return dummy.right;
    }
}
