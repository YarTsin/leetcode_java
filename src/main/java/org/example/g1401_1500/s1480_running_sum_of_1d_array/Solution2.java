package org.example.g1401_1500.s1480_running_sum_of_1d_array;

/**
 * Решение с модификацией исходного массива
 * Подход:
 * Использование исходного массива для экономии памяти.
 */
class Solution2 {
    public int[] runningSum(int[] nums) {
        // Модифицируем исходный массив
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}