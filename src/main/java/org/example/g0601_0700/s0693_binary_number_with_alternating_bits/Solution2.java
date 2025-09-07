package org.example.g0601_0700.s0693_binary_number_with_alternating_bits;

/**
 * Альтернативное решение (Пошаговая проверка битов)
 * Сложность:
 * Временная: O(log n) - количество битов в числе
 * Пространственная: O(1)
 */
class Solution2 {
    public boolean hasAlternatingBits(int n) {
        int lastBit = n & 1; // Получаем младший бит
        n >>= 1; // Сдвигаем вправо

        while (n > 0) {
            int currentBit = n & 1; // Получаем следующий бит
            if (currentBit == lastBit) {
                return false; // Нашли два одинаковых соседних бита
            }
            lastBit = currentBit; // Обновляем последний бит
            n >>= 1; // Сдвигаем дальше
        }

        return true; // Все биты чередуются
    }
}
