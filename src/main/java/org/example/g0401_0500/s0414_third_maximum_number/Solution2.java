package org.example.g0401_0500.s0414_third_maximum_number;

import java.util.Arrays;

/**
 * Альтернативное решение - Решение с использованием сортировки
 * Сортируем массив в порядке убывания
 * Удаляем дубликаты
 * Проверяем наличие третьего элемента
 */
class Solution2 {
    public int thirdMax(int[] nums) {
        // Сортируем массив в порядке возрастания
        Arrays.sort(nums);

        // Удаляем дубликаты
        int n = removeDuplicates(nums);

        // Если уникальных элементов меньше 3, возвращаем максимум
        return (n < 3) ? nums[n - 1] : nums[n - 3];
    }

    private int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }
}