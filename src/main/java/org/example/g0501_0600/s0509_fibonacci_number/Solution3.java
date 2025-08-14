package org.example.g0501_0600.s0509_fibonacci_number;

/**
 * Динамическое программирование с мемоизацией
 * Плюсы: O(n) время, O(n) память. Минусы: использует O(n) памяти,
 * что избыточно для этой задачи.
 */
public class Solution3 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }
}
