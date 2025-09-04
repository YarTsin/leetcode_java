package org.example.g0501_0600.s0572_subtree_of_another_tree;

import org.example.a_leetcode_classes.TreeNode;

/**
 *  Оптимизированное решение с ранним прекращением
 *
 *  Подход:
 * Оптимизируем первое решение с проверкой размеров поддеревьев.
 */
class Solution3 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Сначала проверяем базовые случаи
        if (subRoot == null) return true;
        if (root == null) return false;

        // Если деревья совпадают, возвращаем true
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Рекурсивно проверяем поддеревья
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        if (tree1.val != tree2.val) return false;

        return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
    }
}
