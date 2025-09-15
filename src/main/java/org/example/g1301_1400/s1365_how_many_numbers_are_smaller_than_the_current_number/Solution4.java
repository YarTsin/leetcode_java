package org.example.g1301_1400.s1365_how_many_numbers_are_smaller_than_the_current_number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Решение с использованием HashMap
 */
class Solution4 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // Создаем отсортированную копию
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Используем TreeMap для хранения первого вхождения каждого значения
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            if (!firstOccurrence.containsKey(sorted[i])) {
                firstOccurrence.put(sorted[i], i);
            }
        }

        // Создаем результат
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = firstOccurrence.get(nums[i]);
        }

        return result;
    }
}
