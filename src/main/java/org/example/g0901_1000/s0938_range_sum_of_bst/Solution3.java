package org.example.g0901_1000.s0938_range_sum_of_bst;

import org.example.a_leetcode_classes.TreeNode;

/**
 * In-order traversal
 * Используем in-order обход (левый-узел-правый),
 * который для BST дает отсортированную последовательность.
 */
class Solution3 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // Рекурсивно обходим левое поддерево
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        // Добавляем значение текущего узла, если в диапазоне
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        // Рекурсивно обходим правое поддерево
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }
}
