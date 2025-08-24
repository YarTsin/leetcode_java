package org.example.g0101_0200.s0110_balanced_binary_tree;

import java.util.Stack;

/**
 * Альтернативное решение (Итеративное с DFS)
 */
class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);

            if (Math.abs(leftHeight - rightHeight) > 1) {
                return false;
            }

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return true;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
