package org.example.g1001_1100.s1009_complement_of_base_10_integer;

/**
 * Еще одно альтернативное решение (пошаговое)
 */
class Solution3 {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        int result = 0;
        int power = 1;

        while (n > 0) {
            // Берем младший бит и инвертируем его
            int bit = n & 1;
            int invertedBit = (bit == 0) ? 1 : 0;

            // Добавляем инвертированный бит к результату
            result += invertedBit * power;

            // Сдвигаем число и увеличиваем степень
            n >>= 1;
            power <<= 1;
        }

        return result;
    }
}
