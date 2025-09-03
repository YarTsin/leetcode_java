package org.example.g0001_0100.s0094_binary_tree_inorder_traversal;

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * #Stack
 * Альтернативное решение (Итеративное со стеком)
 *
 */
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 1. Идем до самого левого узла, добавляя все в стек
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 2. Достаем узел из стека (самый левый из непосещенных)
            current = stack.pop();
            result.add(current.val); // Посещаем узел

            // 3. Переходим к правому поддереву
            current = current.right;
        }

        return result;
    }
}
