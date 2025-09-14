package org.example.g1101_1200.s1128_number_of_equivalent_domino_pairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Подход с сортировкой и группировкой
 *
 * Объяснение:
 * Нормализация: Преобразуем все доминошки в нормализованный вид
 * Сортировка: Группируем одинаковые доминошки
 * Подсчет пар: Используем формулу комбинаций C(n,2) = n*(n-1)/2
 * Сложность: Время O(n log n), пространство O(n)
 */
class Solution4 {
    public int numEquivDominoPairs(int[][] dominoes) {
        // Преобразуем каждую доминошку в нормализованную строку
        List<String> normalized = new ArrayList<>();
        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            String key = Math.min(a, b) + "," + Math.max(a, b);
            normalized.add(key);
        }

        // Сортируем для группировки
        Collections.sort(normalized);

        int pairs = 0;
        int currentCount = 1;

        // Подсчитываем пары в отсортированном списке
        for (int i = 1; i < normalized.size(); i++) {
            if (normalized.get(i).equals(normalized.get(i - 1))) {
                currentCount++;
            } else {
                // Добавляем комбинации для предыдущей группы
                pairs += currentCount * (currentCount - 1) / 2;
                currentCount = 1;
            }
        }

        // Добавляем последнюю группу
        pairs += currentCount * (currentCount - 1) / 2;

        return pairs;
    }
}
