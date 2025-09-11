package org.example.g0901_1000.s0961_n_repeated_element_in_size_2n_array;

import java.util.Arrays;

/**
 * Решение с сортировкой
 * Подход: Сортируем массив и ищем два одинаковых соседних элемента.
 *
 * Время: O(n log n) - из-за сортировки
 * Память: O(1) или O(log n) в зависимости от алгоритма сортировки
 */
class Solution3 {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);

        // После сортировки повторяющийся элемент будет где-то рядом
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        // Если не нашли соседних, значит повторяющийся элемент на границах
        return nums[0];
    }
}
