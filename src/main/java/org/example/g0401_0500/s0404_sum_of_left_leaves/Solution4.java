package org.example.g0401_0500.s0404_sum_of_left_leaves;

/**
 * Альтернативное решение - рекурсивное без дополнительного параметра
 * Объяснение: В этом подходе мы проверяем для каждого узла, является
 * ли его левый потомок листом, и если да, добавляем его значение к сумме.
 */
class Solution4 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // Проверяем, есть ли у текущего узла левый потомок-лист
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        // Рекурсивно обходим левое и правое поддеревья
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
