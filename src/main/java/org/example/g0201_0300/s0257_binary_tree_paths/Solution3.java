package org.example.g0201_0300.s0257_binary_tree_paths;

import org.example.a_leetcode_classes.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Альтернативное решение (BFS с использованием очереди)
 */
class Solution3 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Очередь для узлов
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        // Очередь для соответствующих путей
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            String currentPath = pathQueue.poll();

            // Если это лист, добавляем путь в результат
            if (currentNode.left == null && currentNode.right == null) {
                result.add(currentPath);
            }

            // Обрабатываем левого ребенка
            if (currentNode.left != null) {
                nodeQueue.offer(currentNode.left);
                pathQueue.offer(currentPath + "->" + currentNode.left.val);
            }

            // Обрабатываем правого ребенка
            if (currentNode.right != null) {
                nodeQueue.offer(currentNode.right);
                pathQueue.offer(currentPath + "->" + currentNode.right.val);
            }
        }

        return result;
    }
}
