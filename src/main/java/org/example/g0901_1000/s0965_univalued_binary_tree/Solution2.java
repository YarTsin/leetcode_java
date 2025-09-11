package org.example.g0901_1000.s0965_univalued_binary_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Итеративное решение (BFS)
 */
class Solution2 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        int targetValue = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            // Проверяем значение текущего узла
            if (currentNode.val != targetValue) {
                return false;
            }

            // Добавляем дочерние узлы в очередь
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }

        return true;
    }
}
