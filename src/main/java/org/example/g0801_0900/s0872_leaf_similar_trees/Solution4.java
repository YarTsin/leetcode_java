package org.example.g0801_0900.s0872_leaf_similar_trees;

import org.example.a_leetcode_classes.TreeNode;

/**
 * Решение с экономией памяти
 */
class Solution4 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Используем StringBuilder для сравнения без хранения всех листьев
        String leaves1 = getLeavesString(root1);
        String leaves2 = getLeavesString(root2);

        return leaves1.equals(leaves2);
    }

    private String getLeavesString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        getLeavesStringDFS(root, sb);
        return sb.toString();
    }

    private void getLeavesStringDFS(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            sb.append(node.val).append(",");
            return;
        }

        getLeavesStringDFS(node.left, sb);
        getLeavesStringDFS(node.right, sb);
    }
}