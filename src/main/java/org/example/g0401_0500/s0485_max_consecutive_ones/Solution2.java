package org.example.g0401_0500.s0485_max_consecutive_ones;

/**
 * Решение с использованием двух указателей
 * Объяснение:
 * Два указателя: left указывает на начало последовательности, right на конец
 * Обработка нулей: При встрече 0, сдвигаем left за него
 * Подсчет длины: Длина последовательности = right - left + 1
 */
class Solution2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                left = right + 1; // Сдвигаем left за текущий 0
            }
            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }
}
