package org.example.g0601_0700.s0617_merge_two_binary_trees;

import org.example.a_leetcode_classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue; /**
 * Альтернативное решение (Итеративное с использованием очереди)
 */
class Solution3 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{root1, root2});

        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];

            // Пропускаем, если второй узел null
            if (node2 == null) continue;

            // Суммируем значения
            node1.val += node2.val;

            // Обработка левых потомков
            if (node1.left == null) {
                node1.left = node2.left;
            } else {
                queue.offer(new TreeNode[]{node1.left, node2.left});
            }

            // Обработка правых потомков
            if (node1.right == null) {
                node1.right = node2.right;
            } else {
                queue.offer(new TreeNode[]{node1.right, node2.right});
            }
        }

        return root1;
    }
}
