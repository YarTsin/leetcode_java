package org.example.g0301_0400.s0342_power_of_four;

/**
 * Дано целое число n. Необходимо определить,
 * является ли оно степенью числа 4. То есть, существует
 * ли такое целое число x, что 4^x = n.
 *
 * Пример:
 * Input: 16
 * Output: true
 * Explanation: 4^2 = 16
 *
 * Input: 5
 * Output: false
 * Explanation: Не существует целого x, для которого 4^x = 5
 *
 * Подход к решению: Итеративное деление
 *
 */
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 4 == 0) {
            n /= 4;
        }

        return n == 1;
    }
}