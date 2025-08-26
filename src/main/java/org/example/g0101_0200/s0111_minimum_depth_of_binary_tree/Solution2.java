package org.example.g0101_0200.s0111_minimum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Альтернативное решение -
 * BFS с очередью - оптимальное для минимальной глубины
 */
class Solution2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Если нашли лист, возвращаем текущую глубину
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                // Добавляем детей в очередь
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            depth++; // Переходим на следующий уровень
        }

        return depth;
    }
}
