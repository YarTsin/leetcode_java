package org.example.g0901_1000.s0938_range_sum_of_bst;

import org.example.a_leetcode_classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Альтернативное решение (BFS с обходом в ширину)
 * Подход:
 * Используем очередь для обхода в ширину с такой же логикой pruning.
 */
class Solution2 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }

            // Добавляем левого потомка, если есть вероятность найти значения в диапазоне
            if (node.left != null && node.val > low) {
                queue.offer(node.left);
            }

            // Добавляем правого потомка, если есть вероятность найти значения в диапазоне
            if (node.right != null && node.val < high) {
                queue.offer(node.right);
            }
        }

        return sum;
    }
}
