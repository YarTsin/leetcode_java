package org.example.g0201_0300.s0231_power_of_two;

/**
 * Решение с использованием логарифма
 * Плюсы: математически понятное решение
 * Минусы: проблемы с точностью чисел с плавающей точкой
 */
class Solution3 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        double log = Math.log(n) / Math.log(2);
        return Math.abs(log - Math.round(log)) < 1e-10;
    }
}
