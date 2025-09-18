package org.example.g1401_1500.s1480_running_sum_of_1d_array;

/**
 * Рекурсивное решение
 *
 * Подход:
 * Рекурсивный подход (менее эффективен, но демонстрирует альтернативное мышление).
 */
class Solution5 {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        calculateRunningSum(nums, result, nums.length - 1);
        return result;
    }

    private int calculateRunningSum(int[] nums, int[] result, int index) {
        if (index == 0) {
            result[0] = nums[0];
            return nums[0];
        }
        result[index] = calculateRunningSum(nums, result, index - 1) + nums[index];
        return result[index];
    }
}
