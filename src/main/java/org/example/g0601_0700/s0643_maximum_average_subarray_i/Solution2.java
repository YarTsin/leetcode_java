package org.example.g0601_0700.s0643_maximum_average_subarray_i;

/**
 * Альтернативное решение (Префиксные суммы)
 *
 * Сложность:
 * Временная: O(n) - два прохода по массиву
 * Пространственная: O(n) - дополнительный массив для префиксных сумм
 */
class Solution2 {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        // Создаем массив префиксных сумм
        int[] prefixSum = new int[n + 1];

        // Вычисляем префиксные суммы
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Находим максимальную сумму подмассива длины k
        int maxSum = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            int currentSum = prefixSum[i] - prefixSum[i - k];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        // Возвращаем максимальное среднее значение
        return (double) maxSum / k;
    }
}
