package org.example.g1501_1600.s1560_most_visited_sector_in_a_circular_track;

import java.util.ArrayList;
import java.util.List;

/**
 * Полное моделирование (Brute Force)
 */
class Solution2 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] visitCount = new int[n + 1]; // Индексы 1..n
        int current = rounds[0];
        visitCount[current]++;

        // Моделируем весь маршрут
        for (int i = 1; i < rounds.length; i++) {
            int target = rounds[i];

            // Двигаемся к целевому сектору
            while (current != target) {
                current = (current % n) + 1; // Переходим к следующему сектору по кругу
                visitCount[current]++;
            }
        }

        // Находим максимальное количество посещений
        int maxVisits = 0;
        for (int i = 1; i <= n; i++) {
            maxVisits = Math.max(maxVisits, visitCount[i]);
        }

        // Собираем наиболее посещаемые сектора
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (visitCount[i] == maxVisits) {
                result.add(i);
            }
        }

        return result;
    }
}