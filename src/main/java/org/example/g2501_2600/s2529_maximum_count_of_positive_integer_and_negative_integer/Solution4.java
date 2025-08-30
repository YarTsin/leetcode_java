package org.example.g2501_2600.s2529_maximum_count_of_positive_integer_and_negative_integer;

/**
 * Гибридный подход (бинарный поиск + линейный подсчет)
 * Объяснение:
 * Сложность: O(log n + k) времени, где k - количество неотрицательных чисел
 * Подход: Используем бинарный поиск для нахождения границы,
 * затем линейно подсчитываем положительные числа
 */
class Solution4 {
    public int maximumCount(int[] nums) {
        // Находим индекс первого неотрицательного числа
        int firstNonNegative = findFirstNonNegative(nums);

        // Количество отрицательных чисел
        int negativeCount = firstNonNegative;

        // Линейно подсчитываем положительные числа от firstNonNegative
        int positiveCount = 0;
        for (int i = firstNonNegative; i < nums.length; i++) {
            if (nums[i] > 0) {
                positiveCount++;
            }
        }

        return Math.max(negativeCount, positiveCount);
    }

    private int findFirstNonNegative(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= 0) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}