package org.example.g0201_0300.s0231_power_of_two;

/**
 * Задача: является ли заданное целое число степенью двойки.
 * Примеры:
 * 1 → true (2^0)
 * 16 → true (2^4)
 * 3 → false
 * 0 → false (по определению, 0 не является степенью двойки)
 *
 * Оптимальное решение: битовые операции
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (true) {
            if (n == 1) {
                return true;
            }
            if (n % 2 == 1) {
                return false;
            }
            n /= 2;
        }
    }
}
