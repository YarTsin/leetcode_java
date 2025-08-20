package org.example.g0901_1000.s0976_largest_perimeter_triangle;

import java.util.Arrays;

/**
 * Похожее решение
 *
 */
public class Solution2 {
    public int largestPerimeter(int[] nums) {
        // Сортируем массив для удобства проверки троек
        Arrays.sort(nums);

        int n = nums.length;

        // Начинаем с наибольших чисел (с конца массива)
        for (int i = n - 1; i >= 2; i--) {
            int longestSide = nums[i];
            int middleSide = nums[i - 1];
            int shortestSide = nums[i - 2];

            // Для отсортированных сторон достаточно проверить:
            // shortest + middle > longest
            // (остальные неравенства выполняются автоматически)
            if (shortestSide + middleSide > longestSide) {
                return shortestSide + middleSide + longestSide;
            }
        }

        // Если не найдено ни одной валидной тройки
        return 0;
    }
}
