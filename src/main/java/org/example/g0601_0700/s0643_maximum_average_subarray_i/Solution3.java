package org.example.g0601_0700.s0643_maximum_average_subarray_i;

/**
 * Альтернативное решение (Прямой перебор - неэффективно)
 *
 * Сложность:
 * Временная: O(n*k) - для больших n и k будет очень медленно
 * Пространственная: O(1) - константная память
 */
class Solution3 {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = -Double.MAX_VALUE;
        int n = nums.length;

        // Перебираем все возможные начальные позиции
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;

            // Суммируем k элементов, начиная с позиции i
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }

            // Вычисляем среднее и обновляем максимум
            double average = (double) sum / k;
            if (average > maxAverage) {
                maxAverage = average;
            }
        }

        return maxAverage;
    }
}
