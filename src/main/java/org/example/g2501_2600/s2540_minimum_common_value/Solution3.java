package org.example.g2501_2600.s2540_minimum_common_value;

import java.util.HashSet;
import java.util.Set;

/**
 * Подход с хэш-сетом
 * Объяснение:
 * Сложность: O(n + m) времени, O(n) дополнительной памяти
 * Подход: Сохраняем элементы первого массива в хэш-сет,
 * затем ищем общие значения во втором массиве
 * Особенность: Не использует преимущество отсортированности массивов
 */
class Solution3 {
    public int getCommon(int[] nums1, int[] nums2) {
        // Создаем хэш-сет для элементов первого массива
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        // Ищем минимальное общее значение во втором массиве
        int minCommon = Integer.MAX_VALUE;
        for (int num : nums2) {
            if (set.contains(num)) {
                minCommon = Math.min(minCommon, num);
            }
        }

        return minCommon != Integer.MAX_VALUE ? minCommon : -1;
    }
}
