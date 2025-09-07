package org.example.g0601_0700.s0671_second_minimum_node_in_a_binary_tree;

import org.example.a_leetcode_classes.TreeNode;

/**
 * Альтернативное решение (Использование свойств дерева)
 * Сложность:
 * Временная: O(n) - в худшем случае
 * Пространственная: O(h) - высота дерева
 */
class Solution2 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return findSecondMin(root, root.val);
    }

    private int findSecondMin(TreeNode node, int firstMin) {
        if (node == null) {
            return -1;
        }

        // Если значение узла больше первого минимума, это кандидат
        if (node.val > firstMin) {
            return node.val;
        }

        // Рекурсивно ищем в детях
        int leftSecond = findSecondMin(node.left, firstMin);
        int rightSecond = findSecondMin(node.right, firstMin);

        // Если оба ребенка вернули valid значения, берем минимум
        if (leftSecond != -1 && rightSecond != -1) {
            return Math.min(leftSecond, rightSecond);
        }

        // Если только один вернул valid значение
        if (leftSecond != -1) {
            return leftSecond;
        }

        return rightSecond;
    }
}
