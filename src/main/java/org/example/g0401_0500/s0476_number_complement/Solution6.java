package org.example.g0401_0500.s0476_number_complement;

/**
 * Оптимизированное решение с маской (без встроенных методов)
 *
 * Объяснение:
 * Создание полной маски: Распространяем старший бит на все младшие позиции
 * XOR с маской: Эквивалентно инверсии всех значимых битов
 *
 * Пример для num=5 (101):
 * mask = 101
 * mask |= mask>>1: 101 | 010 = 111
 * mask |= mask>>2: 111 | 001 = 111
 * num ^ mask = 101 ^ 111 = 010 = 2
 */
class Solution6 {
    public int findComplement(int num) {
        int mask = num;

        // Распространяем единицы на все младшие биты
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;

        // Теперь mask содержит единицы во всех битах от старшего до младшего
        return num ^ mask;
    }
}