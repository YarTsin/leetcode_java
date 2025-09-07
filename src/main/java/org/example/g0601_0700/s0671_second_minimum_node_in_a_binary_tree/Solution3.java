package org.example.g0601_0700.s0671_second_minimum_node_in_a_binary_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Альтернативное решение (Итеративный обход)
 * Сложность:
 * Временная: O(n) - обход всех узлов
 * Пространственная: O(n) - для очереди
 */
class Solution3 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        long firstMin = Long.MAX_VALUE;
        long secondMin = Long.MAX_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Обновляем минимумы
            if (node.val < firstMin) {
                secondMin = firstMin;
                firstMin = node.val;
            } else if (node.val > firstMin && node.val < secondMin) {
                secondMin = node.val;
            }

            // Добавляем детей в очередь
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }
}
