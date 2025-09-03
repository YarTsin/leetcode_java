package org.example.g0001_0100.s0094_binary_tree_inorder_traversal;

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение (Morris Traversal - без стека)
 */
class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // Если нет левого ребенка, посещаем текущий узел
                result.add(current.val);
                current = current.right; // Переходим к правому ребенку
            } else {
                // Находим предшественника (наибольший узел в левом поддереве)
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Создаем временную связь для обратного возврата
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Удаляем временную связь и посещаем узел
                    predecessor.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }

        return result;
    }
}
