package org.example.g0201_0300.s0292_nim_game;

/**
 * Альтернативное решение (динамическое программирование)
 * Для больших n это решение неэффективно
 * Приведено только для демонстрации логики
 */
class Solution2 {
    public boolean canWinNim(int n) {
        if (n <= 3) return true;

        boolean[] dp = new boolean[n + 1];
        dp[1] = dp[2] = dp[3] = true;

        for (int i = 4; i <= n; i++) {
            // Если есть ход, оставляющий оппонента в проигрышной позиции
            dp[i] = !dp[i-1] || !dp[i-2] || !dp[i-3];
        }

        return dp[n];
    }
}