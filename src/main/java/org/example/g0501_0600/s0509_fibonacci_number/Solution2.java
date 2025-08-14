package org.example.g0501_0600.s0509_fibonacci_number;

/**
 * Рекурсивное решение (неоптимальное)
 * Недостатки: экспоненциальная сложность O(2^n),
 * так как многие значения вычисляются многократно.
 */
public class Solution2 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}
