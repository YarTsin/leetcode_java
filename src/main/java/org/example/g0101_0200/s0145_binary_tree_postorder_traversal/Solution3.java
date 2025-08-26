package org.example.g0101_0200.s0145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Альтернативное решение 2 (Итеративное с одним стеком)
 */
class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        TreeNode lastVisitedNode = null;

        while (currentNode != null || !stack.isEmpty()) {
            // Достигаем самого левого узла
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode peekNode = stack.peek();

                // Если у верхнего узла есть правый потомок и он еще не посещен
                if (peekNode.right != null && lastVisitedNode != peekNode.right) {
                    currentNode = peekNode.right;
                } else {
                    // Добавляем узел в результат и отмечаем как посещенный
                    result.add(peekNode.val);
                    lastVisitedNode = stack.pop();
                }
            }
        }

        return result;
    }
}

/*
Объяснение:
Использует только один стек
Более сложная логика, но экономит память
Отслеживает последний посещенный узел для правильного обхода
 */

