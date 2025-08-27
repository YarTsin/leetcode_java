package org.example.g0401_0500.s0441_arranging_coins;

/**
 * Альтернативное решение - итеративное
 * Объяснение:
 * Последовательно добавляем ряды пока хватает монет
 * Временная сложность: O(√n) - так как k ≈ √(2n)
 * Пространственная сложность: O(1)
 */
class Solution3 {
    public int arrangeCoins(int n) {
        int rows = 0;
        int coinsUsed = 0;

        for (int i = 1; coinsUsed + i <= n; i++) {
            coinsUsed += i;
            rows++;
        }

        return rows;
    }
}
