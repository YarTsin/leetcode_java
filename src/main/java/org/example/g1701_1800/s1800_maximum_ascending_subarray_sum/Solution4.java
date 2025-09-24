package org.example.g1701_1800.s1800_maximum_ascending_subarray_sum;

/**
 * Динамическое программирование
 * Решение с использованием DP, где dp[i] представляет
 * максимальную сумму возрастающего подмассива,
 * заканчивающегося на i-й позиции.
 *
 * Подход:
 * Создаем массив dp такого же размера как nums
 * dp[i] = nums[i] + (если последовательность возрастающая, то dp[i-1], иначе 0)
 * Находим максимум в массиве dp
 */
class Solution4 {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
