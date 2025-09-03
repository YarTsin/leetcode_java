package org.example.g0401_0500.s0461_hamming_distance;

// #Kernighan

/**
 * Решение с использованием Brian Kernighan's algorithm
 *
 * Объяснение алгоритма Кернигана:
 * xor & (xor - 1) удаляет младший установленный бит
 * Цикл выполняется столько раз, сколько установленных битов
 * Более эффективен для чисел с малым количеством установленных битов
 *
 * Пример:
 * xor = 13 (1101)
 * Итерация 1: xor = 1101 & 1100 = 1100, distance=1
 * Итерация 2: xor = 1100 & 1011 = 1000, distance=2
 * Итерация 3: xor = 1000 & 0111 = 0000, distance=3
 *
 *
 */
class Solution3 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;

        // Алгоритм Брайана Кернигана: пропускает нули между единицами
        while (xor != 0) {
            distance++;
            // Убираем младший установленный бит
            xor = xor & (xor - 1);
        }

        return distance;
    }
}
