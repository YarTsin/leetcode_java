package org.example.g1701_1800.s1800_maximum_ascending_subarray_sum;

/**
 * Рекурсивный подход (неэффективно)
 * Рекурсивное решение для демонстрации принципа.
 *
 * Подход:
 * Рекурсивно исследуем все возможные возрастающие подмассивы.
 */
class Solution5 {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 0) return 0;

        int maxSum = Integer.MIN_VALUE;

        // Для каждой начальной позиции находим максимальный возрастающий подмассив
        for (int start = 0; start < nums.length; start++) {
            int currentSum = nums[start];
            maxSum = Math.max(maxSum, currentSum);

            // Продолжаем пока последовательность возрастает
            for (int end = start + 1; end < nums.length; end++) {
                if (nums[end] > nums[end - 1]) {
                    currentSum += nums[end];
                    maxSum = Math.max(maxSum, currentSum);
                } else {
                    break;
                }
            }
        }

        return maxSum;
    }
}