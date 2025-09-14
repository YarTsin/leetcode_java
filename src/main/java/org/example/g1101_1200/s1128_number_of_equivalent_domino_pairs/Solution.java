package org.example.g1101_1200.s1128_number_of_equivalent_domino_pairs;

// #Easy #Array #Hash_Table #Counting

import java.util.HashMap;
import java.util.Map;

/**
 * 1128. Number of Equivalent Domino Pairs
 *
 * Даны доминошки в виде массива пар dominoes[i] = [a, b].
 * Две доминошки [a, b] и [c, d] считаются эквивалентными, если:
 * a == c и b == d, ИЛИ  a == d и b == c
 * То есть доминошки можно переворачивать.
 * Задача: Найти количество пар индексов (i, j) где i < j
 * и доминошки dominoes[i] и dominoes[j] эквивалентны.
 *
 * Пример 1
 * Ввод: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Вывод: 1
 * Объяснение: Эквивалентны только [1,2] и [2,1]
 *
 * Пример 2
 * Ввод: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
 * Вывод: 3
 * Объяснение:
 * Эквивалентные пары:
 * - [1,2] и [1,2] (индексы 0 и 1)
 * - [1,2] и [1,2] (индексы 0 и 3)
 * - [1,2] и [1,2] (индексы 1 и 3)
 *
 * Решение - Подход с HashMap и нормализацией
 * Не быстрое решение - 25 ms
 *
 * Сложность: Время O(n), пространство O(n)
 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> countMap = new HashMap<>();
        int pairs = 0;

        for (int[] domino : dominoes) {
            // Нормализуем доминошку: всегда представляем как [min, max]
            int a = domino[0];
            int b = domino[1];
            String key = Math.min(a, b) + "," + Math.max(a, b);

            // Если такая доминошка уже встречалась, добавляем количество пар
            int count = countMap.getOrDefault(key, 0);
            pairs += count; // Каждая предыдущая доминошка образует пару с текущей
            countMap.put(key, count + 1);
        }

        return pairs;
    }
}
