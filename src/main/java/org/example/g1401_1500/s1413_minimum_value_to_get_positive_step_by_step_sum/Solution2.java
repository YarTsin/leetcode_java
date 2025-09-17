package org.example.g1401_1500.s1413_minimum_value_to_get_positive_step_by_step_sum;

/**
 * Решение с бинарным поиском
 * Объяснение подхода:
 * Используем бинарный поиск в диапазоне от 1 до максимально возможного значения
 * Для каждого кандидата проверяем, удовлетворяет ли он условию
 *
 * Временная сложность: O(n log M), где M - диапазон поиска
 * Пространственная сложность: O(1)
 */
class Solution2 {
    public int minStartValue(int[] nums) {
        int left = 1;               // Минимально возможное startValue
        int right = 100 * 100 + 1;  // Максимально возможное startValue (100 элементов * 100 + 1)

        // Бинарный поиск минимального valid startValue
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isValidStartValue(nums, mid)) {
                right = mid;    // mid - valid, пробуем меньшее значение
            } else {
                left = mid + 1; // mid - invalid, пробуем большее значение
            }
        }

        return left;
    }

    // Проверяет, является ли startValue допустимым
    private boolean isValidStartValue(int[] nums, int startValue) {
        int currentSum = startValue;

        for (int num : nums) {
            currentSum += num;
            if (currentSum < 1) {
                return false;   // Сумма упала ниже 1 - недопустимо
            }
        }

        return true;    // Все суммы ≥ 1
    }
}
