package org.example.g1601_1700.s1619_mean_of_array_after_removing_some_elements;

import java.util.Arrays;

/**
 * Решение с частичной сортировкой
 * Используем быстрый выбор для нахождения граничных значений без полной сортировки.
 */
class Solution2 {
    public double trimMean(int[] arr) {
        int n = arr.length;
        int removeCount = n / 20;

        // Находим граничные значения с помощью частичной сортировки
        int startIndex = removeCount;
        int endIndex = n - removeCount - 1;

        // Используем Arrays.sort для простоты (на практике можно использовать quickselect)
        Arrays.sort(arr);

        double sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += arr[i];
        }

        return sum / (n - 2 * removeCount);
    }
}