package org.example.g0501_0600.s0543_diameter_of_binary_tree;

import org.example.a_leetcode_classes.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Решение с использованием итеративного DFS и HashMap
 */
class Solution3 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Map для хранения высот узлов
        Map<TreeNode, Integer> heightMap = new HashMap<>();
        // Stack для пост-ордер обхода
        Stack<TreeNode> stack = new Stack<>();
        int maxDiameter = 0;

        // Добавляем корень в stack
        stack.push(root);
        // Последний посещенный узел
        TreeNode lastVisited = null;

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.peek();

            // Если узел имеет детей и мы их еще не обработали
            if (lastVisited == null || lastVisited != currentNode.left && lastVisited != currentNode.right) {
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
            } else {
                // Обрабатываем узел (пост-ордер)
                stack.pop();

                // Вычисляем высоты левого и правого поддеревьев
                int leftHeight = heightMap.getOrDefault(currentNode.left, 0);
                int rightHeight = heightMap.getOrDefault(currentNode.right, 0);

                // Высота текущего узла
                int currentHeight = Math.max(leftHeight, rightHeight) + 1;
                heightMap.put(currentNode, currentHeight);

                // Вычисляем диаметр через текущий узел
                int currentDiameter = leftHeight + rightHeight;
                maxDiameter = Math.max(maxDiameter, currentDiameter);

                lastVisited = currentNode;
            }
        }

        return maxDiameter;
    }
}
