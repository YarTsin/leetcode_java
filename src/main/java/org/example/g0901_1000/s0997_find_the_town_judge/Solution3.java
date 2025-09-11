package org.example.g0901_1000.s0997_find_the_town_judge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Решение с использованием множеств
 * Подход: Используем HashSet для отслеживания доверий.
 */
class Solution3 {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;

        Set<Integer> trusters = new HashSet<>(); // те, кто доверяют другим
        Map<Integer, Integer> trustedCount = new HashMap<>(); // счетчик доверий

        for (int[] relation : trust) {
            trusters.add(relation[0]);
            trustedCount.put(relation[1], trustedCount.getOrDefault(relation[1], 0) + 1);
        }

        // Ищем человека, которому доверяют все (n-1) и который никому не доверяет
        for (int i = 1; i <= n; i++) {
            if (!trusters.contains(i) && trustedCount.getOrDefault(i, 0) == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
