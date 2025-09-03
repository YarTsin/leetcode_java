package org.example.g0101_0200.s0144_binary_tree_preorder_traversal;

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * #MorrisTraversal
 * Альтернативное решение (Morris Traversal - без стека)
 */
class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // Случай 1: Нет левого ребенка
                // Просто посещаем текущий узел и идем вправо
                result.add(current.val);
                current = current.right;
            } else {
                // Случай 2: Есть левый ребенок
                // Находим предшественника - самого правого в левом поддереве
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Первое посещение этого поддерева
                    // Создаем временную связь для обратного возврата
                    result.add(current.val); // Посещаем узел ДО создания связи
                    predecessor.right = current; // Создаем временную связь
                    current = current.left; // Идем влево
                } else {
                    // Второе посещение - временная связь уже существует
                    // Значит, мы уже обработали левое поддерево
                    predecessor.right = null; // Удаляем временную связь
                    current = current.right; // Идем вправо
                }
            }
        }

        return result;
    }
}