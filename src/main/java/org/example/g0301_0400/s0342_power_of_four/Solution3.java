package org.example.g0301_0400.s0342_power_of_four;

/**
 * #Math
 * Математический подход с логарифмами
 * Объяснение:
 * Используем формулу изменения основания логарифма: log₄n = ln(n)/ln(4)
 * Проверяем, является ли результат целым числом
 * Может быть проблемы с точностью вычислений с плавающей точкой
 */
class Solution3 {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;

        double log = Math.log(n) / Math.log(4);
        return log == (int)log;
    }
}
