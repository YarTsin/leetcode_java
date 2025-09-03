package org.example.g0101_0200.s0145_binary_tree_postorder_traversal;

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение 1 (Рекурсивное)
 */
class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }

    private void postorderRecursive(TreeNode node, List<Integer> result) {
        // Базовый случай: если узел null, возвращаемся
        if (node == null) {
            return;
        }

        // Рекурсивно обходим левое поддерево
        postorderRecursive(node.left, result);

        // Рекурсивно обходим правое поддерево
        postorderRecursive(node.right, result);

        // Добавляем значение текущего узла (postorder)
        result.add(node.val);
    }
}
/*
Объяснение:
Классический рекурсивный подход
Простая и понятная реализация
Временная сложность: O(n)
Пространственная сложность: O(h) - высота дерева (для стека вызовов)
 */