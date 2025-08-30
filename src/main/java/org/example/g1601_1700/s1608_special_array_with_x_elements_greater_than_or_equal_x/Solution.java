package org.example.g1601_1700.s1608_special_array_with_x_elements_greater_than_or_equal_x;

// #Easy #Array #Sorting #Binary_Search

import java.util.Arrays;

/**
 * 1608. Special Array With X Elements Greater Than or Equal X
 *
 * Условие задачи:
 * Дан массив nums неотрицательных целых чисел. Массив называется
 * особенным, если существует число x такое, что в массиве ровно
 * x элементов, которые больше или равны x.
 * Заметим, что x не обязательно должно быть элементом массива.
 * Необходимо вернуть x, если массив особенный, иначе вернуть -1.
 *
 * Пример 1
 * Вход: nums = [3,5]
 * Выход: 2
 * Объяснение:
 * Есть 2 элемента [3,5], которые больше или равны 2.
 *
 * Пример 2
 * Вход: nums = [0,4,3,0,4]
 * Выход: 3
 * Объяснение:
 * Есть 3 элемента [4,3,4], которые больше или равны 3.
 *
 * Пример 3
 * Вход: nums = [3,6,7,7,0]
 * Выход: -1
 *
 * todo запутанное условие
 * Как я понимаю число элементов > этого же числа
 *
 * Оптимальное решение: Сортировка + Линейный поиск
 *
 * 3 решение по скорости - 2 ms
 *
 */
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int x = 1; x <= n; x++) {
            // Находим первый элемент, который >= x
            // Количество элементов от этого индекса до конца должно быть равно x
            int left = 0;
            int right = n - 1;
            int firstIndex = n;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= x) {
                    firstIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Количество элементов >= x
            int count = n - firstIndex;

            if (count == x) {
                return x;
            }
        }

        return -1;
    }
}
