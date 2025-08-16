package org.example.g0201_0300.s0231_power_of_two;

/**
 * Альтернативое решение
 * Итеративное, не такое эффективное
 *
 * Плюсы: просто для понимания
 * Минусы: O(log n) времени в худшем случае
 */
class Solution2 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    }
}
