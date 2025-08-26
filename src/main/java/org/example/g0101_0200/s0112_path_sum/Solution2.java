package org.example.g0101_0200.s0112_path_sum;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        nodeQueue.offer(root);
        sumQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            int currentSum = sumQueue.poll();

            // Если это лист и сумма совпадает
            if (currentNode.left == null && currentNode.right == null && currentSum == targetSum) {
                return true;
            }

            // Добавляем левого ребенка
            if (currentNode.left != null) {
                nodeQueue.offer(currentNode.left);
                sumQueue.offer(currentSum + currentNode.left.val);
            }

            // Добавляем правого ребенка
            if (currentNode.right != null) {
                nodeQueue.offer(currentNode.right);
                sumQueue.offer(currentSum + currentNode.right.val);
            }
        }

        return false;
    }
}
