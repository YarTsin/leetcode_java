package org.example.g0901_1000.s0993_cousins_in_binary_tree;

import org.example.a_leetcode_classes.TreeNode;

/**
 * Решение с DFS (обход в глубину)
 */
class Solution2 {
    private TreeNode xParent = null;
    private TreeNode yParent = null;
    private int xDepth = -1;
    private int yDepth = -1;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        findNodes(root, null, 0, x, y);

        // Узлы двоюродные если на одинаковой глубине и у разных родителей
        return xDepth == yDepth && xParent != yParent;
    }

    private void findNodes(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if (node == null) return;

        if (node.val == x) {
            xParent = parent;
            xDepth = depth;
        }

        if (node.val == y) {
            yParent = parent;
            yDepth = depth;
        }

        // Если оба узла уже найдены, можно прекратить поиск
        if (xParent != null && yParent != null) return;

        // Рекурсивно ищем в левом и правом поддеревьях
        findNodes(node.left, node, depth + 1, x, y);
        findNodes(node.right, node, depth + 1, x, y);
    }
}
