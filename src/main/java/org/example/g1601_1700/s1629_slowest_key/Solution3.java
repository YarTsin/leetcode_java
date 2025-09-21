package org.example.g1601_1700.s1629_slowest_key;

/**
 * Решение с использованием приоритетной очереди
 * Подход: Использование приоритетной очереди для автоматической сортировки.
 *
 * Сложность: O(n log n) по времени, O(n) по памяти
 */
import java.util.*;

class Solution3 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        // Приоритетная очередь для хранения пар (длительность, клавиша)
        // Сортируем по убыванию длительности, затем по убыванию клавиши
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0]; // По убыванию длительности
            }
            return b[1] - a[1]; // По убыванию клавиши
        });

        // Добавляем первую клавишу
        pq.offer(new int[]{releaseTimes[0], keysPressed.charAt(0)});

        // Добавляем остальные клавиши
        for (int i = 1; i < releaseTimes.length; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            pq.offer(new int[]{duration, keysPressed.charAt(i)});
        }

        // Возвращаем клавишу с максимальной длительностью
        return (char) pq.poll()[1];
    }
}