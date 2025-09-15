package org.example.g1201_1300.s1207_unique_number_of_occurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Более компактное решение
 */
class Solution2 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Подсчет вхождений с использованием лямбда-выражения
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Сравниваем размер Map (уникальные числа) и размер Set (уникальные количества)
        return countMap.size() == new HashSet<>(countMap.values()).size();
    }
}
