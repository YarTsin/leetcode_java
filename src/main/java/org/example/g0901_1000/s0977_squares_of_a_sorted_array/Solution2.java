package org.example.g0901_1000.s0977_squares_of_a_sorted_array;

import java.util.Arrays;

/**
 * Решение с простым преобразованием и сортировкой
 * Подход: Сначала возводим все элементы в квадрат, затем сортируем результат.
 *
 * Сложность:
 * Время: O(n log n) - из-за сортировки
 * Память: O(n) или O(log n) в зависимости от алгоритма сортировки
 *
 * Недостатки:
 * Медленнее из-за сортировки
 * Не использует факт отсортированности исходного массива
 */
class Solution2 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Возводим все элементы в квадрат
        for (int i = 0; i < n; i++) {
            result[i] = nums[i] * nums[i];
        }

        // Сортируем результат
        Arrays.sort(result);
        return result;
    }
}
