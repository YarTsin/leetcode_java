package org.example.g1601_1700.s1646_get_maximum_in_generated_array;

import java.util.Arrays;

/**
 * Решение с рекурсией и мемоизацией (менее эффективное)
 *
 * Подход: Рекурсивное вычисление с запоминанием результатов.
 *
 * Сложность: O(n) по времени, O(n) по памяти
 */
class Solution3 {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;

        int max = 1;
        for (int i = 2; i <= n; i++) {
            max = Math.max(max, calculate(i, memo));
        }

        return max;
    }

    private int calculate(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n % 2 == 0) {
            memo[n] = calculate(n / 2, memo);
        } else {
            int index = n / 2;
            memo[n] = calculate(index, memo) + calculate(index + 1, memo);
        }

        return memo[n];
    }
}
