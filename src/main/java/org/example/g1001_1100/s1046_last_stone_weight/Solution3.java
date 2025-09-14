package org.example.g1001_1100.s1046_last_stone_weight;

/**
 * Альтернативное решение (с использованием счётчика)
 * Основной подход:
 * Для ограниченного диапазона весов можно использовать
 * counting sort, но это менее универсально.
 */
class Solution3 {
    public int lastStoneWeight(int[] stones) {
        // Находим максимальный вес камня
        int maxWeight = 0;
        for (int stone : stones) {
            maxWeight = Math.max(maxWeight, stone);
        }

        // Создаем массив для подсчета весов
        int[] count = new int[maxWeight + 1];
        for (int stone : stones) {
            count[stone]++;
        }

        int biggest = 0;
        int current = maxWeight;

        while (current > 0) {
            if (count[current] == 0) {
                current--;
            } else if (biggest == 0) {
                count[current] %= 2;
                if (count[current] == 1) {
                    biggest = current;
                }
                current--;
            } else {
                if (current > biggest) {
                    count[current]--;
                    biggest = current - biggest;
                    current = biggest;
                    biggest = 0;
                } else {
                    count[current]--;
                    biggest -= current;
                }
            }
        }

        return biggest;
    }
}
