package org.example.g0101_0200.s0190_reverse_bits;

/**
 * Решение с использованием кэширования (для многократных вызовов)
 * Сложность:
 * Время: O(1) - 4 операции
 * Память: O(1) - кэш фиксированного размера (256 элементов)
 */
public class Solution2 {
    // you need treat n as an unsigned value

    // Кэш для байтов
    private final int[] byteCache = new int[256];

    public Solution2() {
        // Инициализируем кэш обращенных байтов
        for (int i = 0; i < 256; i++) {
            byteCache[i] = reverseByte(i);
        }
    }

    public int reverseBits(int n) {
        int result = 0;
        int mask = 0xFF; // Маска для одного байта (11111111)

        // Разбиваем на 4 байта и обращаем каждый
        for (int i = 0; i < 4; i++) {
            result <<= 8; // Освобождаем место для следующего байта
            int currentByte = (n >>> (i * 8)) & mask;
            result |= byteCache[currentByte];
        }

        return result;
    }

    private int reverseByte(int b) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            result <<= 1;
            result |= (b & 1);
            b >>>= 1;
        }
        return result;
    }
}
