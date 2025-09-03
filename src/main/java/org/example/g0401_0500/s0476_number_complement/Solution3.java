package org.example.g0401_0500.s0476_number_complement;

/**
 * Решение с использованием высшего бита
 * Объяснение:
 * Integer.highestOneBit(num) возвращает число с единственной
 * единицей в позиции старшего бита num
 *
 * Для num=5 (101): highestOneBit = 4 (100)
 * mask = (4<<1)-1 = 8-1 = 7 (111)
 */
class Solution3 {
    public int findComplement(int num) {
        // Находим самую старшую единицу
        int highestOneBit = Integer.highestOneBit(num);

        // Создаем маску: (2 * highestOneBit) - 1
        int mask = (highestOneBit << 1) - 1;

        return ~num & mask;
    }
}
