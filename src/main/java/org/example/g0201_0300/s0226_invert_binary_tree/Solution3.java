package org.example.g0201_0300.s0226_invert_binary_tree;

import java.util.Stack;

/**
 * Альтернативное решение 2 (Итеративное с использованием стека)
 * Объяснение:
 * Использует обход в глубину (DFS) с помощью стека
 * Аналогично рекурсивному подходу, но без рекурсии
 * Временная сложность: O(n)
 * Пространственная сложность: O(h)
 */
class Solution3 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();

            // Меняем местами левое и правое поддеревья
            TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;

            // Добавляем правого потомка в стек (если существует)
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            // Добавляем левого потомка в стек (если существует)
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }

        return root;
    }
}
