package org.example.g0601_0700.s0653_two_sum_iv_input_is_a_bst;

import org.example.a_leetcode_classes.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Альтернативное решение (Обход в ширину с HashSet)
 */
class Solution2 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        Set<Integer> seenValues = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            int complement = k - currentNode.val;

            if (seenValues.contains(complement)) {
                return true;
            }

            seenValues.add(currentNode.val);

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }

        return false;
    }
}
