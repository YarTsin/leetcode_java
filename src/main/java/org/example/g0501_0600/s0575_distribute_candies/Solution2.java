package org.example.g0501_0600.s0575_distribute_candies;

import java.util.Arrays;

/**
 *  Решение с сортировкой и подсчетом
 *
 * Преимущества:
 * Память: O(1) - если не считать память для сортировки
 * Не требует дополнительных структур данных
 *
 * Недостатки:
 * Время выполнения: O(n log n) из-за сортировки
 * Медленнее для больших массивов
 */
class Solution2 {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int uniqueCount = 1; // Первый элемент всегда уникальный

        // Подсчитываем уникальные типы после сортировки
        for (int i = 1; i < candyType.length; i++) {
            if (candyType[i] != candyType[i - 1]) {
                uniqueCount++;
            }
        }

        int maxKeep = candyType.length / 2;
        return Math.min(uniqueCount, maxKeep);
    }
}
