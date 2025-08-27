package org.example.g1601_1700.s1608_special_array_with_x_elements_greater_than_or_equal_x;

import java.util.Arrays;

/**
 * Более эффективное решение: Сортировка + один проход
 */
class Solution2 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int x = 1; x <= n; x++) {
            // Находим позицию, где начинаются элементы >= x
            // Это эквивалентно n - x элементу (если массив отсортирован)
            if (nums[n - x] >= x) {
                // Проверяем, что предыдущий элемент (если существует) меньше x
                if (n - x - 1 < 0 || nums[n - x - 1] < x) {
                    return x;
                }
            }
        }

        return -1;
    }
}
