package org.example.g0601_0700.s0700_search_in_a_binary_search_tree;

import org.example.a_leetcode_classes.TreeNode;

/**
 * Рекурсивное решение
 */
class Solution2 {
    public TreeNode searchBST(TreeNode root, int targetValue) {
        // Базовый случай: если дерево пустое или нашли нужный узел
        if (root == null || root.val == targetValue) {
            return root;
        }

        // Если искомое значение меньше значения текущего узла,
        // ищем в левом поддереве
        if (targetValue < root.val) {
            return searchBST(root.left, targetValue);
        }
        // Если искомое значение больше значения текущего узла,
        // ищем в правом поддереве
        else {
            return searchBST(root.right, targetValue);
        }
    }
}
