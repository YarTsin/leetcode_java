package org.example.g0101_0200.s0136_single_number;

import java.util.Arrays;

/**
 * Решение с сортировкой (не удовлетворяет требованию по времени)
 * Сложность:
 * Время: O(n log n) - из-за сортировки
 * Память: O(1) или O(n) в зависимости от реализации сортировки
 */
class Solution3 {
    public int singleNumber(int[] nums) {
        // Сортируем массив
        Arrays.sort(nums);

        // Проходим по массиву с шагом 2
        for (int i = 0; i < nums.length - 1; i += 2) {
            // Если текущий элемент не равен следующему
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        // Если не нашли в цикле, значит единственный элемент - последний
        return nums[nums.length - 1];
    }
}