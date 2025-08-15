package org.example.g0001_0100.s0069_sqrtx;


/**
 * Альтернативное решение (линейный поиск)
 * Не эффективное решение
 *
 * Это решение просто перебирает числа, пока их квадрат
 * не превысит x. Оно работает, но неэффективно
 * для больших чисел (например,
 * для x = 2147395600 потребуется 46340 итераций).
 */
class Solution2 {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int result = 1;
        while ((long) result * result <= x) {
            result++;
        }

        return result - 1;
    }
}
