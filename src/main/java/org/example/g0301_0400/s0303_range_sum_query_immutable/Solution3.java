package org.example.g0301_0400.s0303_range_sum_query_immutable;

/**
 * Решение с кэшированием всех возможных диапазонов
 * Кэширование всех диапазонов: O(n²) память, непрактично для больших n
 */
class Solution3 {
    private int[][] cachedSums;

    public Solution3(int[] nums) {
        int n = nums.length;
        cachedSums = new int[n][n];

        // Предварительно вычисляем все возможные суммы
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                cachedSums[i][j] = currentSum;
            }
        }
    }

    public int sumRange(int left, int right) {
        return cachedSums[left][right];
    }
}
