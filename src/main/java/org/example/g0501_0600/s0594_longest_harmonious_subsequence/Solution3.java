package org.example.g0501_0600.s0594_longest_harmonious_subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Решение с одной итерацией (оптимизированная хэш-карта)
 * Обходим массив один раз
 * Обновляем карту частот и сразу проверяем соседние числа
 * Временная сложность: O(n)
 * Пространственная сложность: O(n)
 */
class Solution3 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxLength = 0;

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

            // Проверяем число на 1 меньше
            if (frequencyMap.containsKey(num - 1)) {
                maxLength = Math.max(maxLength, frequencyMap.get(num) + frequencyMap.get(num - 1));
            }

            // Проверяем число на 1 больше
            if (frequencyMap.containsKey(num + 1)) {
                maxLength = Math.max(maxLength, frequencyMap.get(num) + frequencyMap.get(num + 1));
            }
        }

        return maxLength;
    }
}
