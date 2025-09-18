package org.example.g1401_1500.s1480_running_sum_of_1d_array;

/**
 * Решение с явным накоплением суммы
 * Подход:
 * Использование отдельной переменной для накопления суммы.
 */
class Solution4 {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            result[i] = currentSum;
        }

        return result;
    }
}
