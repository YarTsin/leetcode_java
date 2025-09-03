package org.example.g0401_0500.s0496_next_greater_element_i;

import java.util.HashMap;
import java.util.Map;

/**
 * Решение с использованием HashMap без стека
 *
 * Объяснение:
 * Сохранение индексов: Запоминаем позиции элементов nums2
 * Прямой поиск: Для каждого элемента ищем больший элемент справа
 * Улучшение brute force: Избегаем полного сканирования nums2
 */
class Solution3 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        // Сохраняем индексы элементов nums2
        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i], i);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            int startIndex = indexMap.get(target);
            int nextGreater = -1;

            // Ищем следующий больший элемент начиная с позиции target
            for (int j = startIndex + 1; j < nums2.length; j++) {
                if (nums2[j] > target) {
                    nextGreater = nums2[j];
                    break;
                }
            }

            result[i] = nextGreater;
        }

        return result;
    }
}
