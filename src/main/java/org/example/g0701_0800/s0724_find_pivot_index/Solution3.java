package org.example.g0701_0800.s0724_find_pivot_index;

/**
 * Решение с двумя указателями (менее эффективное)
 * Недостатки:
 * Временная сложность: O(n²) в худшем случае
 * Очень медленно для больших массивов
 */
class Solution3 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int leftSum = 0;
            int rightSum = 0;

            // Вычисляем левую сумму
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            // Вычисляем правую сумму
            for (int j = i + 1; j < n; j++) {
                rightSum += nums[j];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}
