package org.example.g1401_1500.s1464_maximum_product_of_two_elements_in_an_array;

import java.util.Arrays;

/**
 * Решение с Stream API (Java 8)
 *
 * Подход:
 * Функциональный стиль с использованием Stream API.
 */
class Solution5 {
    public int maxProduct(int[] nums) {
        // Сортируем массив и берем два последних элемента
        int[] sorted = Arrays.stream(nums)
                .sorted()
                .toArray();

        int length = sorted.length;
        return (sorted[length - 1] - 1) * (sorted[length - 2] - 1);
    }
}
