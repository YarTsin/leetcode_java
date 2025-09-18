package org.example.g1401_1500.s1464_maximum_product_of_two_elements_in_an_array;

import java.util.Arrays;

/**
 * Альтернативное решение: Сортировка массива
 *
 * Подход:
 * Отсортировать массив и взять два последних (наибольших) элемента.
 *
 * Сложность: O(n log n) по времени,
 * O(1) по памяти (если сортировка на месте)
 */
class Solution2 {
    public int maxProduct(int[] nums) {
        // Сортируем массив
        Arrays.sort(nums);
        int length = nums.length;

        // Берем два наибольших элемента
        int firstMax = nums[length - 1];
        int secondMax = nums[length - 2];

        // Вычисляем произведение
        return (firstMax - 1) * (secondMax - 1);
    }
}
