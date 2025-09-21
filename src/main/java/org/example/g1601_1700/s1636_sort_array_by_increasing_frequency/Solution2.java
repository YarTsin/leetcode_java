package org.example.g1601_1700.s1636_sort_array_by_increasing_frequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Альтернативное решение с использованием приоритетной очереди
 * Подход: Использование PriorityQueue с кастомным компаратором.
 */
class Solution2 {
    public int[] frequencySort(int[] nums) {
        // Подсчет частоты
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Приоритетная очередь с кастомным компаратором
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);

            if (freqA != freqB) {
                return freqA - freqB; // По возрастанию частоты
            } else {
                return b - a; // По убыванию значения
            }
        });

        // Добавление всех элементов в очередь
        for (int num : nums) {
            pq.offer(num);
        }

        // Извлечение элементов в отсортированном порядке
        int[] result = new int[nums.length];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll();
        }

        return result;
    }
}
