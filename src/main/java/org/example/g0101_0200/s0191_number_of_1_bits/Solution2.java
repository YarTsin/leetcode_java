package org.example.g0101_0200.s0191_number_of_1_bits;

/**
 * Решение с побитовым сдвигом
 * Сложность:
 * Время: O(32) - всегда 32 итерации
 * Память: O(1)
 */
public class Solution2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        // Проверяем все 32 бита
        for (int i = 0; i < 32; i++) {
            // Проверяем младший бит
            if ((n & 1) == 1) {
                count++;
            }
            // Сдвигаем вправо (беззнаковый сдвиг)
            n >>>= 1;
        }

        return count;
    }
}
