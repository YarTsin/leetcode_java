package org.example.g0301_0400.s0326_power_of_three;

/**
 * Математический подход с логарифмами
 * Объяснение:
 * Используем формулу изменения основания логарифма: log₃n = log₁₀n / log₁₀3
 * Проверяем, является ли результат целым числом
 * Может быть проблемы с точностью вычислений с плавающей точкой
 */
class Solution3 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        // Используем логарифмы: если log3(n) - целое число, то n - степень тройки
        double log = Math.log10(n) / Math.log10(3);
        return log == (int)log;
    }
}
