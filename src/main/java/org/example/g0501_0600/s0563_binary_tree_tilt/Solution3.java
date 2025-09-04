package org.example.g0501_0600.s0563_binary_tree_tilt;

import org.example.a_leetcode_classes.TreeNode;

/**
 * Решение с использованием дополнительного класса
 * Подход:
 * Используем класс для возврата двух значений из рекурсивной функции.
 *
 */
class Solution3 {
    public int findTilt(TreeNode root) {
        return calculateTiltAndSum(root).tilt;
    }

    private Result calculateTiltAndSum(TreeNode node) {
        if (node == null) {
            return new Result(0, 0);
        }

        Result leftResult = calculateTiltAndSum(node.left);
        Result rightResult = calculateTiltAndSum(node.right);

        int currentTilt = Math.abs(leftResult.sum - rightResult.sum);
        int totalTilt = leftResult.tilt + rightResult.tilt + currentTilt;
        int totalSum = leftResult.sum + rightResult.sum + node.val;

        return new Result(totalTilt, totalSum);
    }

    // Вспомогательный класс для хранения наклона и суммы поддерева
    private class Result {
        int tilt;
        int sum;

        Result(int tilt, int sum) {
            this.tilt = tilt;
            this.sum = sum;
        }
    }
}