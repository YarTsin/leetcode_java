package org.example.g2501_2600.s2529_maximum_count_of_positive_integer_and_negative_integer;


/**
 * линейный поиск
 * Объяснение:
 * Сложность: O(n) времени, O(1) дополнительной памяти
 * Подход: Простой линейный проход по массиву с подсчетом
 * отрицательных и положительных чисел
 * Пропускаем нули, так как они не учитываются
 */
class Solution3 {
    public int maximumCount(int[] nums) {
        int negativeCount = 0;
        int positiveCount = 0;

        for (int num : nums) {
            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveCount++;
            }
        }

        return Math.max(negativeCount, positiveCount);
    }
}
