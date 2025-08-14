package org.example.g1001_1100.s1025_divisor_game;

/**
 * Альтернативное решение (динамическое программирование)
 * Преимущества DP решения:
 * Показывает общий подход к подобным играм
 * Работает для более сложных вариаций игры
 *
 * Недостатки:
 * O(n^2) временная сложность
 * O(n) пространственная сложность
 */
public class Solution2 {
    public boolean divisorGame(int n) {
        if (n == 1) return false;

        boolean[] dp = new boolean[n + 1];
        dp[1] = false; // Проигрышная позиция
        dp[2] = true;  // Выигрышная позиция

        for (int i = 3; i <= n; i++) {
            for (int x = 1; x < i; x++) {
                // Если i делится на x и dp[i-x] проигрышная,
                // то текущий игрок может передать проигрышную позицию
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
