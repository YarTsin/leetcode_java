package org.example.g1601_1700.s1636_sort_array_by_increasing_frequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Решение с использованием массива пар
 * Подход: Создание массива пар (значение, частота) и его сортировка.
 */
class Solution3 {
    public int[] frequencySort(int[] nums) {
        // Подсчет частоты
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Создание массива пар (значение, частота)
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i]; // значение
            pairs[i][1] = frequencyMap.get(nums[i]); // частота
        }

        // Сортировка пар
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1]; // По возрастанию частоты
            } else {
                return b[0] - a[0]; // По убыванию значения
            }
        });

        // Создание результирующего массива
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = pairs[i][0];
        }

        return result;
    }
}
