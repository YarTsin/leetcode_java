package org.example.g1001_1100.s1009_complement_of_base_10_integer;

/**
 * Альтернативное решение (с использованием битовых операций)
 */
class Solution2 {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        // Находим количество битов в числе
        int numBits = (int)(Math.log(n) / Math.log(2)) + 1;

        // Создаем маску из единиц длиной numBits
        int mask = (1 << numBits) - 1;

        // Инвертируем и применяем маску
        return ~n & mask;
    }
}
