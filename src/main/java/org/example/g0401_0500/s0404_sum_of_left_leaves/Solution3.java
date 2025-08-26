package org.example.g0401_0500.s0404_sum_of_left_leaves;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Альтернативное решение - итеративное с использованием очереди
 */
class Solution3 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int totalSum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Boolean> isLeftQueue = new LinkedList<>();

        nodeQueue.offer(root);
        isLeftQueue.offer(false);

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            boolean isLeftChild = isLeftQueue.poll();

            // Проверяем, является ли узел левым листом
            if (currentNode.left == null && currentNode.right == null && isLeftChild) {
                totalSum += currentNode.val;
            }

            // Добавляем левого потомка в очередь
            if (currentNode.left != null) {
                nodeQueue.offer(currentNode.left);
                isLeftQueue.offer(true);
            }

            // Добавляем правого потомка в очередь
            if (currentNode.right != null) {
                nodeQueue.offer(currentNode.right);
                isLeftQueue.offer(false);
            }
        }

        return totalSum;
    }
}
