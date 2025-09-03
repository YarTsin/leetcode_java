package org.example.g0101_0200.s0104_maximum_depth_of_binary_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Альтернативное решение (Итеративное BFS с очередью)
 */
class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++; // Увеличиваем глубину для нового уровня

            // Обрабатываем все узлы текущего уровня
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Добавляем детей в очередь для следующего уровня
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return depth;
    }
}