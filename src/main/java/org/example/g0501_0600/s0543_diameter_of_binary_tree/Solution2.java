package org.example.g0501_0600.s0543_diameter_of_binary_tree;

import org.example.a_leetcode_classes.TreeNode;

/**
 * Альтернативное решение (с возвратом массива)
 */
class Solution2 {
    public int diameterOfBinaryTree(TreeNode root) {
        // Возвращаем только диаметр из результата
        return calculateDiameterAndHeight(root)[0];
    }

    private int[] calculateDiameterAndHeight(TreeNode node) {
        if (node == null) {
            // [диаметр, высота]
            return new int[]{0, 0};
        }

        // Рекурсивно получаем данные для левого и правого поддеревьев
        int[] leftData = calculateDiameterAndHeight(node.left);
        int[] rightData = calculateDiameterAndHeight(node.right);

        // Текущий диаметр = максимум из:
        // - диаметра левого поддерева
        // - диаметра правого поддерева
        // - диаметра через текущий узел (leftHeight + rightHeight)
        int currentDiameter = Math.max(
                Math.max(leftData[0], rightData[0]),
                leftData[1] + rightData[1]
        );

        // Текущая высота = максимум из высот поддеревьев + 1
        int currentHeight = Math.max(leftData[1], rightData[1]) + 1;

        return new int[]{currentDiameter, currentHeight};
    }
}