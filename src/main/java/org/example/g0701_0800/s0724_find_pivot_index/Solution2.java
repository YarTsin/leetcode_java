package org.example.g0701_0800.s0724_find_pivot_index;

/**
 * Решение с массивом префиксных сумм
 * Недостатки:
 * Пространственная сложность: O(n) для хранения префиксных сумм
 * Менее эффективно по памяти
 */
class Solution2 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;

        // Создаем массив префиксных сумм
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int totalSum = prefixSum[n - 1];

        // Проверяем каждый индекс
        for (int i = 0; i < n; i++) {
            int leftSum = (i == 0) ? 0 : prefixSum[i - 1];
            int rightSum = totalSum - prefixSum[i];

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}
