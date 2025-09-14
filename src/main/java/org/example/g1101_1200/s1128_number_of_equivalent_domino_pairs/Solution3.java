package org.example.g1101_1200.s1128_number_of_equivalent_domino_pairs;

import java.util.HashMap;
import java.util.Map;

/**
 * Подход с вычислением хэша
 *
 * Объяснение:
 * Хэширование: Представляем нормализованную доминошку как число min*10 + max
 * Эффективность: Используем целочисленный ключ вместо строки
 * Простота: Более эффективно чем строковый ключ
 * Сложность: Время O(n), пространство O(n)
 */
class Solution3 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int pairs = 0;

        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];

            // Создаем уникальный хэш для нормализованной доминошки
            int hash = Math.min(a, b) * 10 + Math.max(a, b);

            int count = countMap.getOrDefault(hash, 0);
            pairs += count;
            countMap.put(hash, count + 1);
        }

        return pairs;
    }
}
