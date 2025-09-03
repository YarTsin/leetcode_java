package org.example.g0101_0200.s0144_binary_tree_preorder_traversal;

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Альтернативное решение (Итеративное со стеком)
 */
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            result.add(currentNode.val); // Посещаем узел

            // Сначала добавляем правого ребенка, потом левого
            // (чтобы левый обрабатывался первым при извлечении из стека)
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }

        return result;
    }
}
