package org.example.g0201_0300.s0217_contains_duplicate;

import java.util.Arrays;

/**
 * Альтернативное решение
 */
class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        // Сортируем массив
        Arrays.sort(nums);

        // Проверяем соседние элементы
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}