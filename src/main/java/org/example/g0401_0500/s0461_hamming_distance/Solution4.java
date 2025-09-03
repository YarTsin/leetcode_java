package org.example.g0401_0500.s0461_hamming_distance;

// #Kernighan

/**
 * Рекурсивная версия алгоритма Кернигана
 */
class Solution4 {
    public int hammingDistance(int x, int y) {
        return countBits(x ^ y, 0);
    }

    private int countBits(int n, int count) {
        if (n == 0) {
            return count;
        }
        // Рекурсивно считаем биты: убираем младший бит и увеличиваем счетчик
        return countBits(n & (n - 1), count + 1);
    }
}