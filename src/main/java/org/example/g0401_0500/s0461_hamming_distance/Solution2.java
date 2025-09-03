package org.example.g0401_0500.s0461_hamming_distance;

/**
 *  Решение с ручным подсчетом битов (Shift)
 *  Объяснение:
 *  Побитовый AND с 1: Проверяем младший бит
 *  Правый сдвиг: Переходим к следующему биту
 *  Цикл на 32 итерации: Обрабатываем все биты int
 */
class Solution2 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;

        // Проходим по всем 32 битам
        for (int i = 0; i < 32; i++) {
            // Проверяем младший бит
            if ((xor & 1) == 1) {
                distance++;
            }
            // Сдвигаем вправо для проверки следующего бита
            xor >>= 1;
        }

        return distance;
    }
}
