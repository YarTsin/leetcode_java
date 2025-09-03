package org.example.g0401_0500.s0496_next_greater_element_i;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Решение с предварительным вычислением для nums2
 */
class Solution5 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Сначала находим все следующие большие элементы для nums2
        int[] nextGreaterForNums2 = new int[nums2.length];
        Arrays.fill(nextGreaterForNums2, -1);

        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    nextGreaterForNums2[i] = nums2[j];
                    break;
                }
            }
        }

        // Создаем мапу для быстрого доступа
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            valueToIndex.put(nums2[i], i);
        }

        // Строим результат для nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = valueToIndex.get(nums1[i]);
            result[i] = nextGreaterForNums2[index];
        }

        return result;
    }
}
