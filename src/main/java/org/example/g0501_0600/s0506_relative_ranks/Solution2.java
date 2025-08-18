package org.example.g0501_0600.s0506_relative_ranks;

import java.util.Collections;
import java.util.TreeMap;

/**
 * #Tree
 * Решение с TreeMap (автоматическая сортировка)
 * Используем TreeMap для автоматической сортировки по убыванию
 * Сохраняем индексы элементов в мапе
 * Временная сложность: O(n log n)
 * Пространственная сложность: O(n)
 */
class Solution2 {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // TreeMap с обратным порядком сортировки
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }

        int rank = 1;
        for (int key : map.keySet()) {
            int index = map.get(key);
            if (rank == 1) {
                result[index] = "Gold Medal";
            } else if (rank == 2) {
                result[index] = "Silver Medal";
            } else if (rank == 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank);
            }
            rank++;
        }

        return result;
    }
}
