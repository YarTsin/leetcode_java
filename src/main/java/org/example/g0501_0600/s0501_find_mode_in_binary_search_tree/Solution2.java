package org.example.g0501_0600.s0501_find_mode_in_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с одним проходом (используя Morris Traversal)
 *
 * Объяснение:
 * Morris Traversal: In-order обход без рекурсии и стека
 * O(1) память: Не использует дополнительную память для обхода
 * Один проход: Обрабатывает узлы и сразу находит моду
 */
class Solution2 {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> modes = new ArrayList<>();
        Integer prev = null;
        int count = 1;
        int maxCount = 0;

        // Morris In-order Traversal
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                // Обрабатываем текущий узел
                processNode(curr, modes, prev, count, maxCount);
                curr = curr.right;
            } else {
                // Находим предшественника
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    predecessor.right = null;
                    // Обрабатываем текущий узел
                    processNode(curr, modes, prev, count, maxCount);
                    curr = curr.right;
                }
            }
        }

        return modes.stream().mapToInt(i -> i).toArray();
    }

    private void processNode(TreeNode node, List<Integer> modes,
                             Integer prev, int count, int maxCount) {
        if (prev != null) {
            if (node.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }

        if (count > maxCount) {
            maxCount = count;
            modes.clear();
            modes.add(node.val);
        } else if (count == maxCount) {
            modes.add(node.val);
        }

        prev = node.val;
    }
}
