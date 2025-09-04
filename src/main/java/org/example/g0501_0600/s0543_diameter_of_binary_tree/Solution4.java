package org.example.g0501_0600.s0543_diameter_of_binary_tree;

import org.example.a_leetcode_classes.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Решение с использованием двух стеков
 */
class Solution4 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Map<TreeNode, Integer> heightMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> postOrderStack = new Stack<>();
        int maxDiameter = 0;

        // Первый проход: собираем все узлы в stack
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            postOrderStack.push(node);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        // Второй проход: обрабатываем узлы в пост-ордер порядке
        while (!postOrderStack.isEmpty()) {
            TreeNode node = postOrderStack.pop();

            int leftHeight = heightMap.getOrDefault(node.left, 0);
            int rightHeight = heightMap.getOrDefault(node.right, 0);

            // Высота текущего узла
            int currentHeight = Math.max(leftHeight, rightHeight) + 1;
            heightMap.put(node, currentHeight);

            // Диаметр через текущий узел
            int currentDiameter = leftHeight + rightHeight;
            maxDiameter = Math.max(maxDiameter, currentDiameter);
        }

        return maxDiameter;
    }
}