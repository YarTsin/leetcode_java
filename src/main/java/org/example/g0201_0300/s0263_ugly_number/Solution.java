package org.example.g0201_0300.s0263_ugly_number;

/**
 * Дано целое число n. Необходимо определить, является ли оно
 * "ugly number" (некрасивым числом).
 * Ugly number - это положительное число, простые множители
 * которого ограничены числами 2, 3 и 5.
 *
 * Пример:
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 *
 * Input: 14
 * Output: false
 * Explanation: 14 = 2 × 7 (7 - это дополнительный простой множитель)
 *
 * Используем итеративный подход к решению
 */
class Solution {
    public boolean isUgly(int n) {
        // Обработка особых случаев
        if (n <= 0) {
            return false; // Ugly numbers определены только для положительных чисел
        }

        // Последовательно делим на 2, 3 и 5, пока это возможно
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }

        // Если после всех делений осталась 1, значит других простых множителей нет
        return n == 1;
    }
}