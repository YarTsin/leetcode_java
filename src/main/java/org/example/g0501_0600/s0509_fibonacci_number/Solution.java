package org.example.g0501_0600.s0509_fibonacci_number;

/** +
 * LeetCode Easy
 *
 * Как я понимаю это и есть классическая задача
 * на динамическое программирование - использование
 * результатов предыдущих вычислений
 *
 * Задача: вычислить n-ое число Фибоначчи.
 * Числа Фибоначчи определяются так:
 * F(0) = 0
 * F(1) = 1
 * F(n) = F(n-1) + F(n-2) для n > 1
 *
 * Оптимальное решение - итеративное
 */
public class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int prev1 = 0; // F(0)
        int prev2 = 1; // F(1)
        int current = 0;

        for(int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }
}

/*
Примеры:
F(2) = F(1) + F(0) = 1 + 0 = 1
F(3) = F(2) + F(1) = 1 + 1 = 2
F(4) = F(3) + F(2) = 2 + 1 = 3
*/

