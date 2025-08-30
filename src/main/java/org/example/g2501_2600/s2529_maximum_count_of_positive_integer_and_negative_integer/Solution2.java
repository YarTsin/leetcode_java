package org.example.g2501_2600.s2529_maximum_count_of_positive_integer_and_negative_integer;

/**
 * Оптимизированный подход с одним бинарным поиском
 * Объяснение:
 * Сложность: O(log n) времени, O(1) дополнительной памяти
 * Подход: Используем два бинарных поиска:
 * findFirstPositive - находит первый положительный элемент
 * findLastNegative - находит последний отрицательный элемент
 * Количество отрицательных чисел = индекс последнего отрицательного + 1
 * Количество положительных чисел = общая длина - индекс первого положительного
 */
class Solution2 {
    public int maximumCount(int[] nums) {
        // Находим индекс первого положительного числа
        int firstPositiveIndex = findFirstPositive(nums);

        // Находим количество отрицательных чисел через бинарный поиск
        int negativeCount = findLastNegative(nums) + 1;

        int positiveCount = nums.length - firstPositiveIndex;

        return Math.max(negativeCount, positiveCount);
    }

    private int findFirstPositive(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > 0) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private int findLastNegative(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < 0) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
