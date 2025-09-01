package org.example.g0201_0300.s0228_summary_ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с двумя указателями
 * Сложность:
 * Время: O(n) - каждый элемент посещается один раз
 * Память: O(1) дополнительной памяти
 */
class Solution2 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int i = 0;
        while (i < nums.length) {
            int start = nums[i];
            int j = i;

            // Находим конец последовательных чисел
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                j++;
            }

            if (i == j) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + nums[j]);
            }

            i = j + 1; // Переходим к следующему диапазону
        }

        return result;
    }
}
