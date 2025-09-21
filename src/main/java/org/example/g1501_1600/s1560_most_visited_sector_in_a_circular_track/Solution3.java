package org.example.g1501_1600.s1560_most_visited_sector_in_a_circular_track;

import java.util.ArrayList;
import java.util.List;

/**
 * Оптимизированное моделирование
 */
class Solution3 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] frequency = new int[n + 1];

        // Обрабатываем каждый отрезок пути
        for (int i = 0; i < rounds.length - 1; i++) {
            int from = rounds[i];
            int to = rounds[i + 1];

            if (from <= to) {
                // Прямое движение
                for (int j = from; j < to; j++) {
                    frequency[j]++;
                }
            } else {
                // Движение через ноль
                for (int j = from; j <= n; j++) {
                    frequency[j]++;
                }
                for (int j = 1; j < to; j++) {
                    frequency[j]++;
                }
            }
        }

        // Учитываем конечную точку последнего раунда
        frequency[rounds[rounds.length - 1]]++;

        // Находим максимальную частоту
        int maxFreq = 0;
        for (int i = 1; i <= n; i++) {
            maxFreq = Math.max(maxFreq, frequency[i]);
        }

        // Собираем результат
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (frequency[i] == maxFreq) {
                result.add(i);
            }
        }

        return result;
    }
}